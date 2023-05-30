package com.dxc.cs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/allEmployee")
	public ModelAndView employeeList() throws EmployeeException
	{
		return new ModelAndView("employeeList","employee",employeeService.getAllEmployees());
	}
	@GetMapping("/newEmployee")
	public ModelAndView addEmployee() {
		return new ModelAndView("employeeForm","employee",new Employee());
	}
	@PostMapping("/newEmployee")
	public ModelAndView doAddEmployee( @ModelAttribute("employee") Employee employee,BindingResult bindingResult) throws EmployeeException
	{
		
		ModelAndView mv=null;
		if(bindingResult.hasErrors()) {
			mv=new ModelAndView("employeeForm","employee",employee);
		}
		else {
			employeeService.addEmployee(employee);
			mv = new ModelAndView("redirect:/home");
			
		}
		return mv;
	}
	
	
	
	
	
	
}
