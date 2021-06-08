package org.assignment4;

public class ClockMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock=new Clock();
		
		Thread tick=new Thread(new TickJob(clock),"tick");
		Thread tack=new Thread(new TackJob(clock),"tack");
		Thread tock=new Thread(new TockJob(clock),"tock");
		tick.start();
		tack.start();
		tock.start();
		

	}

}
