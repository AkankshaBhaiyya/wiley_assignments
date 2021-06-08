package com.Assignment;

public class WorkerMain {
	public static void main(String args[])
	{
		Worker dailyWorker=new DailyWorker("Annapurna",8);
		Worker salariedWorker=new SalariedWorker("Akanksha",8);
		System.out.println("Daily Workers Pay : "+dailyWorker.pay(5));
		System.out.println("Daily Workers Pay : "+salariedWorker.pay(40));
	}

}
