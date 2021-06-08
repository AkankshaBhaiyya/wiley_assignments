package BankImpl;
import org.bank.*;

public class SavingAccount implements DepositAcc,CreditInterest{
	public void withdraw()
	{
		System.out.println("This is SAccount withdraw");
	}
	public void deposit()
	{
		System.out.println("This is SAccount withdraw");
	}
	public void getBalance()
	{
		System.out.println("This is SAccount ");
	}
	public void addMonthlyInt()
	{
		System.out.println("This is SAccount Montlyinterest");
	}
	public void addHalfYearlyInt()
	{
		System.out.println("This is SAccount Halfyearlyaccount");
	}
	public void addAnnualInt()
	{
		System.out.println("This is SAccount Annualinterest");
	}
	public void createAccount()
	{
		System.out.println("SAccount created");
	}
	public void calculateInterest()
	{
		System.out.println("SAccount interest calculated");
	}
}
