package org.zoo;
import org.animals.*;
public class ZooMain {
	public static void main(String args[])
	{
	
		Animal deer =new Deer("deer","Brown",10,10);
		VandalurZoo vandalurzoo=new VandalurZoo();
		vandalurzoo.setAnimal(deer);
		vandalurzoo.print();
		Animal tiger =new Tiger("tiger","Brown",10,10);
		vandalurzoo.setAnimal(tiger);
		vandalurzoo.print();
		
	}

}
