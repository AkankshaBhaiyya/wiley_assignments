package com.sujata.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sujata.bean.Employee;

public interface EmployeeDao {

	Collection<Employee> getAllRecords();
	boolean insertEmployee(Employee employee);
	Employee getRecordsById(int id);
	String deleteRecordsById(int id);
	Employee updateRecordsSalaryById(int id,int salary);
}
