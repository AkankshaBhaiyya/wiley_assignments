package org.assignment4;

public class EggsJob implements Runnable{
	private OwnerEggsDisplay ownerEggsDisplay;
	public EggsJob(OwnerEggsDisplay ownerEggsDisplay)
	{
		super();
		this.ownerEggsDisplay=ownerEggsDisplay;
	}
	@Override
	public void run() {
		
		for(int i=0;i<50;i++)
		{
			ownerEggsDisplay.showEggs(i+1);
		}
	}

}
