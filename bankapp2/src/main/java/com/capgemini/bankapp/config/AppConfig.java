package com.capgemini.bankapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.capgemini.bankapp"})
@PropertySource(value = "classpath:config.properties")
public class AppConfig {
	
	
	@Value("${driver}")
	private String driver;
	@Value("${DB_URL}")
	private String DB_URL;
	@Value("${USER}")
	private String USER;
	@Value("${PASSWORD}")
	private String PASSWORD;
	
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/piggybank");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;*/
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate geJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
		
	}

}
