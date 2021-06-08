package org.assignment4;

public class EggsOwnerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwnerEggsDisplay ownerEggsDisplay=new OwnerEggsDisplay();;
		
		Thread egg=new Thread(new EggsJob(ownerEggsDisplay));
		Thread owner=new Thread(new OwnerJob(ownerEggsDisplay));
		egg.start();
		owner.start();

	}

}
