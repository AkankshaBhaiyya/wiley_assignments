package com.Assignment;

public class SalariedWorker extends Worker {
	
    SalariedWorker(String name,int salaryRate)
	{
		super(name,salaryRate);
	
	}
	public int pay(int hours)
	{
	
		int salaryRate=getSalaryRate();
		if(hours < 40) {
			return hours* salaryRate;
		}
		else
		{
		return 40 * salaryRate;
		}
	}
}
