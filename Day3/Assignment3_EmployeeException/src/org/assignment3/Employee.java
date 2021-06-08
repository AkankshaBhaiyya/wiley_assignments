package org.assignment3;

import java.util.ArrayList;

public class Employee {
	
	private String name;
	private static ArrayList<String> namesList=new ArrayList<String>();
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) throws NameCheckedException{
		this.name=name;
		if(namesList.contains(name))
		{
			throw new NameCheckedException("Name already exists");
		}
		namesList.add(name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<18 || age>60)
		{
			throw new AgeUncheckedException("Age should not be less than 18 and it also should not be greater than 60 ");
		}
		this.age=age;
	}

}
