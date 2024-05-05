package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceWithJPA implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public int addEmployee(Employee emp) {
		
		Employee e=employeeRepository.save(emp);
		
		if(e!=null)
			return 1;
		else
			return 0;
	
	}

	@Override
	public int updateEmployee(int empId, Employee emp) {
		Employee oldemp=employeeRepository.findById(empId).orElse(null);
		oldemp.setEmpId(emp.getEmpId());
		oldemp.setEmpName(emp.getEmpName());
		oldemp.setEmpSalary(emp.getEmpSalary());
		
		employeeRepository.save(oldemp);
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return 0;
	}

	@Override
	public Employee findempById(int empId) {
		
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

}
