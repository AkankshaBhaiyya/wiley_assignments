package org.assignment4;

public class TickJob implements Runnable{
	private int[] seconds= new int[60];
	
	private Clock clock;
	
	
	public TickJob(Clock clock) {
		super();
		this.clock = clock;
		for(int i=0;i<60;i++)
		{
			seconds[i]=i+1;
		}
	}


	public void run() {
		for(int secondsval:seconds) {
			clock.showTick(secondsval);
		}
	}

}

