package org.animals;

public class Monkey extends Animal {

	public Monkey(String name,String color,int weight, int age)
	{
		super(name,color,weight,age);
	}
	public boolean isVegetarian()
	{
		return true;
	}
	public boolean canClimb()
	{
		return true;
	}
	public String sound()
	{
		return "MonkeySound";
	}
}
