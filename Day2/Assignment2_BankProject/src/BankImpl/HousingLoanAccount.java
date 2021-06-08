package BankImpl;
import org.bank.*;
public class HousingLoanAccount implements LoanAcc,DebitInterest{
	public void repayPrincipal()
	{
		System.out.println("HLA repayPrincipal");
	}
	public void payInterest()
	{
		System.out.println("HLA payInterest");
	}
	public void payPartialPrincipal()
	{
		System.out.println("HLA payPartialInterest");
	}
	public void deductMonthlyInt()
	{
		System.out.println("HLA deductMonthly");
	}
	public void deductHalfYearlyInt()
	{
		System.out.println("HLA deductHalfyearly");
	}
	public void deductAnnualInt()
	{
		System.out.println("HLA deductAnnual");
	}
	public void createAccount()
	{
		System.out.println("HLA created");
	}
	public void calculateInterest()
	{
		System.out.println("HLA interest");
	}
}
