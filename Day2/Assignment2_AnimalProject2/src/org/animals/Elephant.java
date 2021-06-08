package org.animals;

public class Elephant extends Animal{
	public Elephant(String name,String color,int weight, int age)
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
		return "ElephantSound";
	}
}
