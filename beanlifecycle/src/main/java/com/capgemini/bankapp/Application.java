package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;

public class Application {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController", BankAccountController.class);
		
		
		try {
			System.out.println(bankAccountController.getBalance(12345));
			bankAccountController.fundTransfer(12345, 123456, 200000);
			System.out.println(bankAccountController.getBalance(12345));
			
			bankAccountController.updateBalance(123456, 50000);
			System.out.println(bankAccountController.getBalance(123456));
			
			bankAccountController.withdraw(12345, 500);
			System.out.println(bankAccountController.getBalance(12345));
		
			bankAccountController.deposit(12345, 150);
			System.out.println(bankAccountController.getBalance(12345));
		} catch (AccountNotFoundException | LowBalanceException e) {
			System.out.println(e.getMessage());
		}
		
	
	}

}
