package com.dxc.cs.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin

public class EmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger("EmployeeApi");

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() throws EmployeeException {

		List<Employee> elist = employeeService.getAllEmployees();
		if (elist.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Employee>>(elist, HttpStatus.OK);
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
			response = new ResponseEntity<Employee>(employee,HttpStatus.OK);
			logger.info("SucessFully added Employee");
		}
		return response;

	}

	@GetMapping("/name/{empName}")

	public ResponseEntity<Employee> getByEmployeeName(@PathVariable("empName") String empName)
			throws EmployeeException {

		Employee emp = employeeService.findByName(empName);
		if (emp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("/id/{empId}")
	public ResponseEntity<Employee> getByEmpId(@PathVariable("empId") int empId) throws EmployeeException {
		Employee emp = employeeService.getById(empId);
		if (emp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Employee> deleteByEmpId(@PathVariable("empId") int empId) throws EmployeeException {
		Employee emp = employeeService.getById(empId);
		if (emp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		employeeService.deleteEmployee(empId);
		logger.info("Employee deleted SucessFully");
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, BindingResult result)
			throws EmployeeException {
		ResponseEntity<Employee> response = null;

		if (result.hasErrors()) {

			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : result.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
			}
			logger.error("failed to update employee! try again...");
			throw new EmployeeException(errMsg.toString());
		} else {
			employeeService.update(employee);
			logger.info("successfully updated employee data...");
			response = new ResponseEntity<>(employee, HttpStatus.OK);

		}

		return response;
	}

}
