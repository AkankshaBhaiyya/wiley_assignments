package org.assignment4;

public class OwnerEggsDisplay {
private boolean flag=false;
	
	synchronized void showEggs(int noOfEggs) {
		  while(flag==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hen laid the Egg-"+noOfEggs);
		flag=true;
		notify();
	}
	
	synchronized void showOwner(int profit) {
		while(flag==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Owner gained Rs "+profit);
		flag=false;
		notify();
	}
	
}
