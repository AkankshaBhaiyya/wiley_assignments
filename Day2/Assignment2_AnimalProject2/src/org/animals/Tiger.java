package org.animals;

public class Tiger extends Animal{
	public Tiger(String name,String color,int weight, int age)
	{
		super(name,color,weight,age);
	}
	public boolean isVegetarian()
	{
		return false;
	}
	public boolean canClimb()
	{
		return true;
	}
	public String sound()
	{
		return "TigerSound";
	}
}
