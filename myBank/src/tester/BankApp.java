package tester;
import java.time.LocalDate;
import java.util.*;

import java.lang.Exception;

import java.util.Scanner;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import custom_Exception.MyBankingException;
import utils.BankingUtils;

public class BankApp  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner sc= new Scanner(System.in)){
			
			Map<Integer, BankAccount> accounts= BankingUtils.bhardo();
			
			boolean loop=true;
			
			while(loop)
			{
				System.out.println("Options 1. Create A/C 2. Display all accts 3. Fetch A/C Summary "
						+ "4. Transfer Funds 5. Close A/c 100.Exit");
				
				try {
					switch(sc.nextInt())
					{
					case 1: 
						System.out.println("Enter Account number you want to create");
						int acctNo = sc.nextInt();
						if(!accounts.containsKey(acctNo))
						{
							System.out.println( "Enter CustomerName, Account Type, balance, Account opening Date");
							accounts.put(acctNo, 
									new BankAccount(acctNo,sc.next(),AccountType.valueOf(sc.next().toUpperCase()),BankingUtils.validateBalance(sc.nextDouble()),LocalDate.parse(sc.next())));
							
						}
						else
							throw new MyBankingException("Bhai kar kya raha hai tu.. Account No. already Exist");
						
						break;
						
					case 2:
						
						for(BankAccount baby: accounts.values())
							System.out.println(baby);
						break;
						
					case 3:
						System.out.println("Enter Account number to get Account Summary");
						int ac = sc.nextInt();
						if(accounts.containsKey(ac))
						{
							BankAccount targetAccount = accounts.get(ac);
							System.out.println("Account Summary of Account number: "+targetAccount+" is -");
							System.out.println(targetAccount);
						}
						else
							throw new MyBankingException("Bhosdike bro Sahi Account number daal na");
						break;
						
					case 4:
						
						System.out.println("Enter Sender's Account");
						int srcAcc = sc.nextInt();
						System.out.println("Enter Reciever's Account");
						int recAcc= sc.nextInt();
						if(accounts.containsKey(srcAcc) && accounts.containsKey(recAcc))
						{
							BankAccount sAcc=accounts.get(srcAcc);
							BankAccount rAcc=accounts.get(recAcc);
							sAcc.fundTransfer(sc.nextDouble(), rAcc);
						}
						break;
						
					case 5:
						System.out.println("Ente Accopunt you want to Delete");
						int delAcc = sc.nextInt();
						if(accounts.containsKey(delAcc))
						{
							accounts.remove(delAcc);
						}
						else
							throw new MyBankingException("Gaand k Andhe..Sahi Account number daal na bhosdike");
						
						break;
						
					case 100:
						loop=true;
						
						default:
							System.out.println("Please select from given options");
					
					}
					
				} catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
			
//		   for(BankAccount baby: accounts.values())
//		   {
//			   System.out.println(baby);
//		   }
			
			
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
//			sc.nextLine();
		}

	}

}
