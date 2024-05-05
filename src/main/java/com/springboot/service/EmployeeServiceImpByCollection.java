package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
@Service
public class EmployeeServiceImpByCollection implements EmployeeService{

	private List<Employee> empList=new ArrayList<>();
	
	public EmployeeServiceImpByCollection() {
	 empList.add(new Employee(101,"Raksha",50000));
	 empList.add(new Employee(102,"Ruha",52000));
	 empList.add(new Employee(103,"Rakshu",38000));
	 empList.add(new Employee(104,"Priya",28000));
	 empList.add(new Employee(105,"Mohini",25000));
	}

	@Override
	public int addEmployee(Employee emp) {
		
		boolean flag=empList.add(emp);
		System.out.println("Emp : "+emp);
		return flag?1:0;
	}

	@Override
	public int updateEmployee(int empId, Employee emp) {
		for(Employee employee:empList) {
			if(employee.getEmpId()==empId) {
				int index = empList.indexOf(employee);
				empList.set(index, emp);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		for(Employee employee:empList) {
			if(employee.getEmpId()==empId) {
				empList.remove(employee);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Employee findempById(int empId) {
		for(Employee employee: empList) {
			if(employee.getEmpId()==empId) {
				empList.remove(employee);
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return empList;
	}

}
