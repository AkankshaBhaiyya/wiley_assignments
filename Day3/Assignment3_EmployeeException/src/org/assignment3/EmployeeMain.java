package org.assignment3;


import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		try 
		{
			Employee employee1=new Employee();
			System.out.println("Enter number of employees");
			int numberOfEmployees=scanner.nextInt();
			for(int i=0;i<numberOfEmployees;i++) {
			System.out.println("Enter employee name");
			String name=scanner.next();
			System.out.println("Enter age");
			int age=scanner.nextInt();
			employee1.setName(name);
			employee1.setAge(age);
			//listemployee.add(employee1);
			System.out.println("Name : "+employee1.getName());
			System.out.println("Age : "+ employee1.getAge());
			}
			//Employee employee2=new Employee();
			
			
		}
		catch(NameCheckedException nameexception)
		{
			System.out.println("Employee name is duplicate");
		}
		catch(AgeUncheckedException ageexception)
		{
			System.out.println("Employee age is not in the required range");
	    }
		

	}

}
