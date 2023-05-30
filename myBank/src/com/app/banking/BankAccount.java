package com.app.banking;

import utils.BankingUtils;

import java.lang.*;

import custom_Exception.MyBankingException;

import java.time.LocalDate;

public class BankAccount {
	
	private int acccNo;
	private String CustomerName;
	private AccountType acct;
	private double balance;
	private LocalDate acctOpeningDate;
	
	//Constructor
	
	public BankAccount(int acccNo, String customerName, AccountType acct, double balance, LocalDate acctOpeningDate) {
		super();
		this.acccNo = acccNo;
		this.CustomerName = customerName;
		this.acct = acct;
		this.balance = balance;
		this.acctOpeningDate = acctOpeningDate;
	}

	@Override
	public String toString() {
		return "BankAccount [acccNo=" + acccNo + ", CustomerName=" + CustomerName + ", acct=" + acct + ", balance="
				+ balance + ", acctOpeningDate=" + acctOpeningDate + "]"; 
	}
	
	public double deposite(double amount)
	{
		return (balance+amount);
	}
	
	public void fundTransfer(double amount, BankAccount destAcc) throws MyBankingException
	{
		this.withdraw(amount);
		destAcc.deposite(amount);
	}
	
	public double withdraw(double amount) throws MyBankingException
	{
     return BankingUtils.validateBalance(this.balance-amount);
	}

	public int getAcccNo() {
		return acccNo;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public AccountType getAcct() {
		return acct;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getAcctOpeningDate() {
		return acctOpeningDate;
	}
	

	
	

}
