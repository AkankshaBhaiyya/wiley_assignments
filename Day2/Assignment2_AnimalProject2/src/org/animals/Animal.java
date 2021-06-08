package org.animals;

abstract public class Animal {
	private int  weight,age;
	private String color ,name;
	public Animal(String name,String color, int weight, int age) {
		super();
		this.name=name;
		this.color = color;
		this.weight = weight;
		this.age = age;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName()
	{
		this.name=name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	abstract public boolean isVegetarian();
	abstract public boolean canClimb();
	abstract public String sound();

	
}
