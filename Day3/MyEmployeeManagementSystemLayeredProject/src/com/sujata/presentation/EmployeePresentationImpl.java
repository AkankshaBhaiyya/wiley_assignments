package com.sujata.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sujata.bean.Employee;
import com.sujata.helper.EmployeeInputOutput;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService=new EmployeeServiceImpl();
	@Override
	public void showMenu() {
		System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
		System.out.println("1. Display All Employees");
		System.out.println("2. Add New Employee");
		System.out.println("3. Search By ID");
		System.out.println("4. Delete By ID");
		System.out.println("5. Update Salary By Id");
		System.out.println("6. Exit");
	}

	@Override
	public void performMenu(int choice) {
		switch(choice) {
		case 1:
			Collection<Employee> employees=employeeService.getAllEmployees();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			break;
		case 2:
			if(employeeService.saveEmployee(EmployeeInputOutput.inputEmployee()))
				System.out.println("Employee Record Added Succefully");

			else
				System.out.println("Employee Record Insertion Failed");
			break;
		case 3:
			   //String employeesString=employeeService.getEmployeeById(EmployeeInputOutput.inputEmployeeId());
		
			   //System.out.println(employeesString);
			   Employee employeesId=employeeService.getEmployeesById(EmployeeInputOutput.inputEmployeeId());
			   //for(Employee employeekey:employeesId) {
					System.out.println(employeesId);
			//}
		
			break;
		case 4://String employeesdeleteString=employeeService.deleteEmployeeById(EmployeeInputOutput.inputEmployeeId());
		
		   //System.out.println(employeesdeleteString);
			    String employeesdel=employeeService.deleteEmployeesById(EmployeeInputOutput.inputEmployeeId());
			
				System.out.println(employeesdel);
				break;
		case 5: Employee employeesIdSalryUpdate=employeeService.updateEmployeeSalaryById(EmployeeInputOutput.inputEmployeeId(),EmployeeInputOutput.inputEmployeeSalary());
		   
				System.out.println(employeesIdSalryUpdate);
			break;
			
		case 6:
			System.out.println("Thanks for using Employee Management System!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}

	}

}
