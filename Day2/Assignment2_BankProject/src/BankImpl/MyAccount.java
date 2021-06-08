package BankImpl;

public class MyAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FDAccount fdaccount=new FDAccount();
		HousingLoanAccount housingloanaccount=new HousingLoanAccount();
		PersonalLoanAccount personalloanaccount=new PersonalLoanAccount();
		SavingAccount savingaccount=new SavingAccount();
		fdaccount.withdraw();
		fdaccount.deposit();
		fdaccount.getBalance();
		fdaccount.addMonthlyInt();
		fdaccount.addHalfYearlyInt();
		fdaccount.addAnnualInt();
		fdaccount.createAccount();
		fdaccount.calculateInterest();
		savingaccount.withdraw();
		savingaccount.deposit();
		savingaccount.getBalance();
		savingaccount.addMonthlyInt();
		savingaccount.addHalfYearlyInt();
		savingaccount.addAnnualInt();
		savingaccount.createAccount();
		savingaccount.calculateInterest();
		personalloanaccount.calculateInterest();
		personalloanaccount.payInterest();
		personalloanaccount.payPartialPrincipal();
		personalloanaccount.repayPrincipal();
		personalloanaccount.deductMonthlyInt();
		personalloanaccount.deductHalfYearlyInt();
		personalloanaccount.deductAnnualInt();
		personalloanaccount.createAccount();
		housingloanaccount.calculateInterest();
		housingloanaccount.payInterest();
		housingloanaccount.payPartialPrincipal();
		housingloanaccount.repayPrincipal();
		housingloanaccount.deductMonthlyInt();
		housingloanaccount.deductHalfYearlyInt();
		housingloanaccount.deductAnnualInt();
		housingloanaccount.createAccount();
	}

	
}
