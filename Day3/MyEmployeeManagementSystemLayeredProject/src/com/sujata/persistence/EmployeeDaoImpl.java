package com.sujata.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sujata.bean.Employee;
import com.sujata.database.EmployeeList;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Collection<Employee> getAllRecords() {
		 HashMap<Integer,Employee> employees=EmployeeList.getEmployees();
		 Collection<Employee> emps=employees.values();
		return emps;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		EmployeeList.getEmployees().put(employee.geteId(), employee);
		return true;
	}
 
    @Override
	public Employee getRecordsById(int id) {
		HashMap<Integer,Employee> employeesId=EmployeeList.getEmployees();
		Set<Integer> set=employeesId.keySet();
		
		for(Integer key:set)
		{
			if(key==id)
			{
				return employeesId.get(key);
			}
		}
		return null;
			
	}
   

	@Override
	public String deleteRecordsById(int id) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,Employee> employees=EmployeeList.getEmployees();
		Set<Integer> setdel=employees.keySet();
		String s="Element not deleted";
		try {
		for(Integer keydel:setdel)
		{
			if(keydel == id)
			{
				s="";
				employees.remove(keydel);
				s=s+"deleted";
			}
		}
		}
		catch(ConcurrentModificationException exception)
		{
			
		}
		return s;
		
	}

	@Override
	public Employee updateRecordsSalaryById(int id,int salary) {
		HashMap<Integer,Employee> employeesSalary=EmployeeList.getEmployees();
		Set<Integer> setSalary=employeesSalary.keySet();
		
		for(Integer keySalary:setSalary)
		{
			if(keySalary==id)
			{
				 //employeesSalary.setSalary(salary);
				 employeesSalary.get(keySalary).setSalary(salary);
				 return employeesSalary.get(keySalary);
			}
		}
		return null;
	}
	
	 
	 

}
