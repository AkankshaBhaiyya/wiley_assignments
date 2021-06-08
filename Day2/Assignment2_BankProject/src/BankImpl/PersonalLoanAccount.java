package BankImpl;

import org.bank.*;

public class PersonalLoanAccount implements LoanAcc,DebitInterest {
	public void repayPrincipal()
	{
		System.out.println("PLA repayPrincipal");
	}
	public void payInterest()
	{
		System.out.println("PLA payInterest");
	}
	public void payPartialPrincipal()
	{
		System.out.println("PLA payPartialInterest");
	}
	public void deductMonthlyInt()
	{
		System.out.println("PLA deductMonthly");
	}
	public void deductHalfYearlyInt()
	{
		System.out.println("PLA deductHalfyearly");
	}
	public void deductAnnualInt()
	{
		System.out.println("PLA deductAnnual");
	}
	public void createAccount()
	{
		System.out.println("PLA created");
	}
	public void calculateInterest()
	{
		System.out.println("PLA interest");
	}

}
