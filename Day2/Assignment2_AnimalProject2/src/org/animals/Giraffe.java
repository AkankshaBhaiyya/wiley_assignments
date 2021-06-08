package org.animals;

public class Giraffe extends Animal{
	public Giraffe(String name,String color,int weight, int age)
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
		return "GiraffeSound";
	}
	
	
}
