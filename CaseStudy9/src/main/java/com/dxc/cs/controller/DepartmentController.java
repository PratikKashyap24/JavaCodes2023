package com.dxc.cs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.model.Department;
import com.dxc.cs.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/allDepartment")
	public ModelAndView departmentList() throws EmployeeException {
		return new ModelAndView("departmentList", "department", departmentService.getAllDepartments());
	}

	@GetMapping("/newDepartment")
	public ModelAndView addDepartmnet() {
		return new ModelAndView("departmentForm", "department", new Department());
	}

	@PostMapping("/newDepartment")
	public ModelAndView doAddEmployee(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult)
			throws EmployeeException {

		ModelAndView mv = null;
		if (bindingResult.hasErrors()) {
			mv = new ModelAndView("departmentForm", "department", department);
		} else {
			departmentService.addDepartment(department);
			mv = new ModelAndView("redirect:/home");

		}
		return mv;
	}
	
	
	
	
	
}
