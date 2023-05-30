package utils;

import java.lang.Exception;

import com.app.banking.AccountType;

import com.app.banking.BankAccount;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import custom_Exception.MyBankingException;


public class BankingUtils {
	
	public static final double MIN_BALANCE;
	
	static
	{
		MIN_BALANCE=10000;
	}
	
	public static double validateBalance(double balance) throws MyBankingException {
		if(balance < MIN_BALANCE)
			throw new MyBankingException("Insufficient Balance");
		return balance;
	}
	
	public static Map<Integer, BankAccount> bhardo() throws MyBankingException
	{
		Map<Integer, BankAccount> meraBank = new HashMap<>();
		System.out.println(meraBank.put(101, 
				new BankAccount(101,"Anuja", AccountType.SAVINGS ,validateBalance(500000),LocalDate.parse("2022-11-18"))));
		System.out.println(meraBank.put(102, 
				new BankAccount(102,"Gobi",  AccountType.FD ,validateBalance(100000),LocalDate.parse("2022-11-13"))));
		System.out.println(meraBank.put(103,
				new BankAccount(103,"Jamun",  AccountType.CURRENT ,validateBalance(200000),LocalDate.parse("2022-11-18"))));
		return meraBank;
	}
	
	public static AccountType validateAccountType(String type)
	{
		return AccountType.valueOf(type.toUpperCase());
	}

}
