package org.zoo;

import org.animals.Animal;

public class VandalurZoo {
	private Animal animal;

	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void print()
	{
		System.out.println(animal.getName()+" is "+animal.getColor()+"Colored");
		System.out.println(animal.getName()+" is "+animal.getWeight()+"weight and "+animal.getAge()+" aged");
		if(animal.isVegetarian()==true) {
		System.out.println("Vegetarian");
		}
		else
		{
			System.out.println("Non Vegetarian");
		}
		if(animal.canClimb()==true)
		{
			System.out.println("can climb");
		}
		else
		{
			System.out.println("cannot climb");
		}
		System.out.println("Animal Sound : "+animal.sound());
	}

}
