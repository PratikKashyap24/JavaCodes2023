package com.dxc.cs.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("/company")
@CrossOrigin
public class CompanyApi {

	@Autowired
	private CompanyService companyService;

	private static final Logger logger = LoggerFactory.getLogger("CompanyApi");

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompany() throws EmployeeException {
		List<Company> cmp = companyService.getAllCompanies();
		HttpHeaders hd = new HttpHeaders();
		hd.add("series", "companyseries");
		if (cmp.isEmpty()) {
			return new ResponseEntity<List<Company>>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(hd).body(cmp);
	}

	@PostMapping
	public ResponseEntity<String> addCompany(@Valid @RequestBody Company company, BindingResult bindingResult)
			throws EmployeeException {

		if (companyService.getByCompId(company.getCompId()) != null) {
			return new ResponseEntity<String>("Company Id already Registered", HttpStatus.BAD_REQUEST);
		}

		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : bindingResult.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
				logger.error("Cannot add company");

			}
			return new ResponseEntity<String>(errMsg.toString(), HttpStatus.BAD_REQUEST);
			// throw new EmployeeException(errMsg.toString());
		} else {
			companyService.addCompany(company);
			logger.info("Company added SucessFully");
			return new ResponseEntity<String>("Company added SucessFully", HttpStatus.OK);
		}

	}

	@GetMapping("/name/{compName}")

	public ResponseEntity<Company> getByCompanyName(@PathVariable("compName") String compName)
			throws EmployeeException {
		Company cmp = companyService.findByCompName(compName);
		if (cmp == null) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Company>(companyService.findByCompName(compName), HttpStatus.OK);
	}

	@GetMapping("/id/{compId}")
	public ResponseEntity<Company> getByCompId(@PathVariable("compId") int compId) throws EmployeeException {

		Company cmp = companyService.getByCompId(compId);
		if (cmp == null) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(companyService.getByCompId(compId));
	}

	@DeleteMapping("/{compId}")
	public ResponseEntity<String> deleteByCompId(@PathVariable("compId") int compId) throws EmployeeException {

		if (companyService.getByCompId(compId) == null) {
			return new ResponseEntity<String>("Company Id not found ", HttpStatus.BAD_REQUEST);
		}

		companyService.deleteCompany(compId);
		logger.info("Company Deleted SucessFully");
		return new ResponseEntity<>("Company Deleted SucessFully", HttpStatus.OK);

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
