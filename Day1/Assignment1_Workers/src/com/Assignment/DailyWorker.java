package com.Assignment;

public class DailyWorker extends Worker {
	
	DailyWorker(String name,int salaryRate)
	{
		super(name,salaryRate);
	
	}
	public int pay(int days)
	{
		int hours= days * 24;
		int salaryRate=getSalaryRate();
		return hours* salaryRate;
	}

}
