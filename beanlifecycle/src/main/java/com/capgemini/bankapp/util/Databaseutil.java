package com.capgemini.bankapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class Databaseutil {

	@Autowired
	private  Environment env;
	public  Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(env.getProperty("driver"));
			connection = DriverManager.getConnection(env.getProperty("DB_URL"),env.getProperty("USER"),env.getProperty("PASSWORD"));
			if(connection != null)
				System.out.println("--connected -- ");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}

