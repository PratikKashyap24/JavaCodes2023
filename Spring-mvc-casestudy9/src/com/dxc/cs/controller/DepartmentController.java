package com.dxc.cs.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;
import com.dxc.cs.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/deptList")
	public ModelAndView departmentHome() throws EmployeeException {
		ModelAndView mv = new ModelAndView("deptList");
		List<Department> deptList = departmentService.getAllDepartment();
		mv.addObject("deptList", deptList);
		return mv;

	}

	@RequestMapping("/newDepartment")
	public String newDepartmentForm(Map<String, Object> model) {
		model.put("department", new Department());
		return "new_dept";
	}

	@PostMapping(value = "/saveDept")
	public ModelAndView saveDepartment(@Valid @ModelAttribute("department") Department department,
			BindingResult bindingResult) throws EmployeeException {
		ModelAndView mv;
		if (bindingResult.hasErrors()) {
			mv = new ModelAndView("new_dept", "department", department);
		} else {
			departmentService.save(department);
			mv = new ModelAndView("redirect:/");
		}
		return mv;

	}

}
