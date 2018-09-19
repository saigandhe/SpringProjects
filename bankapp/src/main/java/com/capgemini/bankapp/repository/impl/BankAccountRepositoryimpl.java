package com.capgemini.bankapp.repository.impl;

import java.util.HashSet;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;

public class BankAccountRepositoryimpl implements BankAccountRepository {
	
	private HashSet<BankAccount> accounts;
	
	public BankAccountRepositoryimpl() {
		super();
		accounts = new HashSet<>();
		accounts.add(new BankAccount(123,"Naina","SAVINGS",35000));
		accounts.add(new BankAccount(103,"Shu","SAVINGS",30000));
		accounts.add(new BankAccount(203,"Chi","CURRENT",10000));
	}

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : accounts) {
			if(bankAccount.getAccountId()==accountId)
				return bankAccount.getAccountBalance();
			
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : accounts) {
			if(BankAccount.getAccountId()==accountId)
				bankAccount.setAccountBalance(newBalance);
			return true;
			
		}
		
		return false;
	}

}
