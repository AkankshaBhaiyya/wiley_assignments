package org.assignment4;

public class TackJob implements Runnable{
	private int[] seconds= new int[60];
	private Clock clock;
	
	
	public TackJob(Clock clock) {
		super();
		this.clock = clock;
		for(int i=0;i<60;i++)
		{
			seconds[i]=i+1;
		}
	}


	public void run() {
		for(int secondsval:seconds) {
			clock.showTack(secondsval);
		}
	}

}
