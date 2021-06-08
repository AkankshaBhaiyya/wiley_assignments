package org.animals;

public class AnnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal deer=new Deer("a","brown",10,10);
	
		System.out.println(deer.canClimb());
		System.out.println(deer.isVegetarian());
		System.out.println(deer.sound());

	}

}
