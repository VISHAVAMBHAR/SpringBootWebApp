package com.springboot.controller;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
    //private static final Logger log = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	@Qualifier("employeeServiceWithJPA")
	EmployeeService employeeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView emplist() {
		
		List<Employee> elist= employeeService.findAllEmployee();
		ModelAndView mv= new ModelAndView();
		mv.addObject("emplist", elist);
		mv.setViewName("emplist");
		return mv;
	}
	@GetMapping(value = "/form")
	public String empform() {
		
		return "empform";
	}
	
	@PostMapping(value = "/save")
	public String empsave(@ModelAttribute Employee emp) {
		
		employeeService.addEmployee(emp);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping(value = "/delete/{empId}")
	public String empDelete(@PathVariable int empId) {
		
		employeeService.deleteEmployee(empId);
		return "redirect:/employee/list";
	}
	
	@GetMapping(value = "/update/{empId}")
	public ModelAndView empEdit(@PathVariable int empId) {
		
		Employee emp=employeeService.findempById(empId);
		System.out.println("delete emp find by id : "+emp);
		ModelAndView mv=new ModelAndView();
		mv.addObject("emp",emp);
		mv.setViewName("empupdateform");
		System.out.println("mv : "+mv);
		return mv;
	}
	
	@PostMapping(value = "/update/{empId}")
	public String updateEmp(@PathVariable int empId, @ModelAttribute Employee emp) {
		
		employeeService.updateEmployee(empId, emp);
		
		return "redirect:/employee/list";
	}
	
}
