package BankImpl;

import org.bank.CreditInterest;
import org.bank.DepositAcc;

public class FDAccount implements DepositAcc,CreditInterest{
	public void withdraw()
	{
		System.out.println("This is FDAAccount withdraw");
	}
	public void deposit()
	{
		System.out.println("This is FDAAccount withdraw");
	}
	public void getBalance()
	{
		System.out.println("This is FDAAccount ");
	}
	public void addMonthlyInt()
	{
		System.out.println("This is FDAAccount Montlyinterest");
	}
	public void addHalfYearlyInt()
	{
		System.out.println("This is FDAccount Halfyearlyaccount");
	}
	public void addAnnualInt()
	{
		System.out.println("This is FDAAccount Annualinterest");
	}
	public void createAccount()
	{
		System.out.println("FDAAccount created");
	}
	public void calculateInterest()
	{
		System.out.println("FDAAccount interest calculated");
	}

}
