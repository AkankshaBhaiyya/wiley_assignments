package com.sujata.helper;

import java.util.Scanner;

import com.sujata.bean.Employee;

public class EmployeeInputOutput {

	public static Employee inputEmployee() {
		Scanner scanner=new Scanner(System.in);
		
		Employee employee=new Employee();
		
		System.out.println("Enter Employee ID");
		employee.seteId(scanner.nextInt());
		System.out.println("Enter Employee Name ");
		employee.seteName(scanner.next());
		System.out.println("Enter Employee Designation ");
		employee.setDesig(scanner.next());
		System.out.println("Enter Employee Department ");
		employee.setDeptt(scanner.next());
		System.out.println("Enter Employee Salary ");
		employee.setSalary(scanner.nextInt());

		return employee;
	}
	public static int inputEmployeeId()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		return id;
	}
	public static int inputEmployeeSalary()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter salary");
		int salary=sc.nextInt();
		return salary;
	}
}
