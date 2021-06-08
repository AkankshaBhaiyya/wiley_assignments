package org.assignment4;

public class OwnerJob implements Runnable{
	private OwnerEggsDisplay ownerEggsDisplay;
	public OwnerJob(OwnerEggsDisplay ownerEggsDisplay)
	{
		super();
		this.ownerEggsDisplay=ownerEggsDisplay;
	}
	@Override
	public void run() {
		
		for(int i=0;i<50;i++)
		{
			int res=2 * (i+1);
			ownerEggsDisplay.showOwner(res);
		}
	}

}
