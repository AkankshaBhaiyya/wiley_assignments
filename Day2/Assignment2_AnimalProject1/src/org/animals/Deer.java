package org.animals;

public class Deer extends Animal {
	public Deer(String name,String color,int weight, int age)
	{
		super(name,color,weight,age);
	}
	public boolean isVegetarian()
	{
		return true;
	}
	public boolean canClimb()
	{
		return false;
	}
	public String sound()
	{
		return "DeerSound";
	}

}
