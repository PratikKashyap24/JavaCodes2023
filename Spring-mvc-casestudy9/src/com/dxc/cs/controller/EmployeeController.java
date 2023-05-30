package com.dxc.cs.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Employee;
import com.dxc.cs.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/empList")
	public ModelAndView home() throws EmployeeException {
		ModelAndView mv = new ModelAndView("empList");
		List<Employee> empList = employeeService.getAllEmployee();
		mv.addObject("empList", empList);
		return mv;
	}

	@RequestMapping("/newEmp")
	public String newEmployeeForm(Map<String, Object> model) {
		model.put("employee", new Employee());
		return "new_emp";

	}

	@PostMapping(value ="/saveEmp")
	public ModelAndView saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) throws EmployeeException {
		ModelAndView mv;
		if (result.hasErrors()) {
			mv = new ModelAndView("new_emp", "employee", employee);
		} else {
			employeeService.save(employee);
			mv = new ModelAndView("redirect:/");
		}

		return mv;
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(name = "empId") Integer empId) throws EmployeeException {
		employeeService.deleteById(empId);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public ModelAndView editEmployee(@RequestParam(name = "empId") Integer empId) {

		return new ModelAndView("EditEmpPage", "employee", employeeService.getById(empId));
	}

	@PostMapping("/edit")
	public ModelAndView doUpdateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) throws EmployeeException {

		ModelAndView mv = null;
		if (result.hasErrors()) {
			mv = new ModelAndView("EditEmpPage", "employee", employee);
		} else {
			employeeService.update(employee);
			mv = new ModelAndView("redirect:/");
		}
		return mv;
	}
	
	
	
	
}
