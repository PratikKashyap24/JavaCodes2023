package com.dxc.cs.api;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.CompanyService;


@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyApi {

	@Autowired
	private CompanyService companyService;

	private static final Logger logger = Logger.getLogger("CompanyApi");
	@GetMapping
	public ResponseEntity<List<Company>> getAllEmployee() throws EmployeeException {
		return new ResponseEntity<List<Company>>(companyService.getAllCompanies(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Company> addBook(@Valid @RequestBody Company company, BindingResult bindingResult)
			throws EmployeeException {
		ResponseEntity<Company> response = null;

		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : bindingResult.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
				logger.error("Cannot add company");
			}
			throw new EmployeeException(errMsg.toString());
		} else {
			companyService.addCompany(company);
			logger.info("Company added SucessFully");
			response = new ResponseEntity<Company>(HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/name/{compName}")

	public ResponseEntity<Company> getByEmployeeName(@PathVariable("compName") String compName)
			throws EmployeeException {
		return new ResponseEntity<Company>(companyService.findByCompName(compName), HttpStatus.OK);
	}

	@GetMapping("/id/{compId}")
	public ResponseEntity<Company> getByEmpId(@PathVariable("compId") int compId) throws EmployeeException {
		return new ResponseEntity<Company>(companyService.getByCompId(compId), HttpStatus.OK);
	}

	@DeleteMapping("/{compId}")
	public ResponseEntity<Company> deleteByBcode(@PathVariable("compId") int compId) throws EmployeeException {
		companyService.deleteCompany(compId);
		logger.info("Company Deleted SucessFully");
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping
	public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company company, BindingResult result)
	throws EmployeeException {
	ResponseEntity<Company> response = null;

	 if (result.hasErrors()) {

	 StringBuilder errMsg = new StringBuilder();
	for (FieldError err : result.getFieldErrors()) {
	errMsg.append(err.getDefaultMessage() + ",");
	}
	logger.error("failed to update company! try again...");
	throw new EmployeeException(errMsg.toString());
	} else {
	companyService.update(company);
	logger.info("successfully updated company data...");
	response = new ResponseEntity<>(company, HttpStatus.OK);

	 }

	 return response;
	}
	
	
	
	
	
	
	
	
}
