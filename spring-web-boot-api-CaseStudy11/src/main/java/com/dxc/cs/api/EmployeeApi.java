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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.EmployeeService;
@CrossOrigin
@RestController
@RequestMapping("/employee")

public class EmployeeApi {

	@Autowired
	private EmployeeService employeeService;
  
	private static final Logger logger = Logger.getLogger("EmployeeApi");
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() throws EmployeeException {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult)
			throws EmployeeException {
		ResponseEntity<Employee> response = null;

		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : bindingResult.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
				logger.error("Cannot add Employee");
			}
			throw new EmployeeException(errMsg.toString());
		} else {
			employeeService.addEmployee(employee);
			response = new ResponseEntity<Employee>(HttpStatus.OK);
			logger.info("SucessFully added Employee");
		}
		return response;

	}

	@GetMapping("/name/{empName}")

	public ResponseEntity<Employee> getByEmployeeName(@PathVariable("empName") String empName)
			throws EmployeeException {
		return new ResponseEntity<Employee>(employeeService.findByName(empName), HttpStatus.OK);
	}

	@GetMapping("/id/{empId}")
	public ResponseEntity<Employee> getByEmpId(@PathVariable("empId") int empId) throws EmployeeException {
		
		Employee emp=employeeService.getById(empId);
		if(emp==null) {
			String msg=" No Match Found ";
		       
			return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
			
						
		} 
		
		return new ResponseEntity(emp, HttpStatus.OK);
		
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Employee> deleteByBcode(@PathVariable("empId") int empId) throws EmployeeException {
		Employee emp=employeeService.getById(empId);
		employeeService.deleteEmployee(empId);
		logger.info("Employee deleted SucessFully");
		return new ResponseEntity(emp,HttpStatus.OK);
	}

}
