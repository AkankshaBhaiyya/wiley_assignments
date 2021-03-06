package com.sujata.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sujata.bean.Employee;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public Collection<Employee> getAllEmployees() {
		
		return employeeDao.getAllRecords();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}
	@Override
	public Employee getEmployeesById(int id) {
		
		return employeeDao.getRecordsById(id);
	}
	@Override
	public String deleteEmployeesById(int id) {
		
		return employeeDao.deleteRecordsById(id);
	}

	@Override
	public Employee updateEmployeeSalaryById(int id,int salary) {
		// TODO Auto-generated method stub
		return employeeDao.updateRecordsSalaryById(id,salary);
	}
	

}
