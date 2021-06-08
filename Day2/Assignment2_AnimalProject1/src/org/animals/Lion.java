package org.animals;

public class Lion extends Animal{
	public Lion(String name,String color,int weight, int age)
	{
		super(name,color,weight,age);
	}
	public boolean isVegetarian()
	{
		return false;
	}
	public boolean canClimb()
	{
		return false;
	}
	public String sound()
	{
		return "LionSound";
	}

}
