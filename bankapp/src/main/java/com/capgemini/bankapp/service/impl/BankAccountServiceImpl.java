package com.capgemini.bankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	
	private BankAccountRepository bankAccountRepository;

//	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
//		this.bankAccountRepository = bankAccountRepository;
//	}

	
	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {

		return bankAccountRepository.getBalance(accountId);
	}
	@Autowired
	private BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
	super();
	this.bankAccountRepository = bankAccountRepository;
}

	@Override
	public double withdraw(long accountId, double amount)throws LowBalanceException, AccountNotFoundException {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance != -1) {
			if (balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			}
			else {
				throw new LowBalanceException("You dont have sufficient balance");
				
			}
		}
		return balance;
	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {

		double balance = bankAccountRepository.getBalance(accountId);
		if (balance != -1) {
			bankAccountRepository.updateBalance(accountId, balance+amount);
			return bankAccountRepository.getBalance(accountId);
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException, AccountNotFoundException {

		double balance = withdraw(fromAccount, amount);
		if (balance != -1)
			if(deposit(toAccount,amount) == -1) {
			deposit(toAccount, amount);
		return false;
	}
		return true;
}
	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		return false;
	}
}


