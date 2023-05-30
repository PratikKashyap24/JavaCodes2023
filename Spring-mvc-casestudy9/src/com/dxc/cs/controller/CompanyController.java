package com.dxc.cs.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/compList")
	public ModelAndView companyHome() throws EmployeeException{
		ModelAndView mv=new ModelAndView("compList");
		List<Company> compList=companyService.getAllCompany();
		mv.addObject("compList",compList);
		return mv;
	}
	@RequestMapping("/newCompany")
	public String newCompanyForm(Map<String,Object> model) {
	model.put("company", new Company());
	return "new_comp";
	
}
	@PostMapping(value = "/saveComp")
	public ModelAndView saveCompany(@Valid @ModelAttribute("company") Company company,BindingResult result) throws EmployeeException
	{
		ModelAndView mv;
		if(result.hasErrors()) {
			mv=new ModelAndView("new_comp","company",company);
		}
		else {
			companyService.save(company);
			mv=new ModelAndView("redirect:/");
		}
		return mv;
	}
	
	

}