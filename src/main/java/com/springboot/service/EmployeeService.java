package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
	
	int addEmployee(Employee emp);
	
	int updateEmployee(int empId,Employee emp);
	
	int deleteEmployee(int empId);
	
	Employee findempById(int empId);
	
	List<Employee> findAllEmployee();

}
