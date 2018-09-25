package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.util.Databaseutil;

@Repository

public class BankAccountRepositoryimpl implements BankAccountRepository {
	
	@Autowired
	Databaseutil databaseutil;
	
	
	
	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		String query = "SELECT balance FROM accounts WHERE account_id = ?";
		try (Connection connection = databaseutil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setLong(1, accountId);
			try(ResultSet result = statement.executeQuery()){
			if (result.next()) {
				return result.getDouble(1);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account doesn't exist!");
	
	


//	@Override
//	public double getBalance(long accountId) {
//		for (BankAccount bankAccount : accounts) {
//			if(bankAccount.getAccountId()==accountId)
//				return bankAccount.getAccountBalance();
//			
//		}
//		return -1;
//	}
//
//	@Override
//	public boolean updateBalance(long accountId, double newBalance) {
//		for (BankAccount bankAccount : accounts) {
//			if(bankAccount.getAccountId()==accountId)
//				bankAccount.setAccountBalance(newBalance);
//			
//		}
		
//		return false;
	}



	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		String query = "UPDATE accounts SET balance = ? WHERE account_id = ?";
		try (Connection connection = databaseutil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			if(statement.executeUpdate() != 0) {
				System.out.println("Record inserted successfully");
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}






	
}
