
package com.dxc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/allCompany")
	public ModelAndView companyList() throws EmployeeException {
		return new ModelAndView("companyList", "company", companyService.getAllCompanies());
	}
 
	
	@GetMapping("/newCompany")
	public ModelAndView addCompany() {
		return new ModelAndView("companyForm", "company", new Company());
	}

	@PostMapping("/newCompany")
	public ModelAndView doAddEmployee(@ModelAttribute("company") Company company, BindingResult bindingResult)
			throws EmployeeException {

		ModelAndView mv = null;
		if (bindingResult.hasErrors()) {
			mv = new ModelAndView("companyForm", "company", company);
		} else {
			companyService.addCompany(company);
			mv = new ModelAndView("redirect:/home");

		}
		return mv;
	}

}
