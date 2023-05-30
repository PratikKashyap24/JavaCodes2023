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

import com.dxc.cs.entity.Department;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.DepartmentService;
@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentApi {

	@Autowired
	private DepartmentService departmentService;
      
	private static final Logger logger = Logger.getLogger("DepartmentApi");
	
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment() throws EmployeeException {
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Department> addBook(@Valid @RequestBody Department department, BindingResult bindingResult)
			throws EmployeeException {
		ResponseEntity<Department> response = null;

		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : bindingResult.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
				logger.error("Cannot add this Department");
			}
			throw new EmployeeException(errMsg.toString());
		} else {
			departmentService.addDepartment(department);
			response = new ResponseEntity<Department>(HttpStatus.OK);
			logger.info("Department added SucessFully");
		}
		return response;

	}

	@GetMapping("/name/{deptName}")

	public ResponseEntity<Department> getByEmployeeName(@PathVariable("deptName") String deptName)
			throws EmployeeException {
		return new ResponseEntity<Department>(departmentService.findByDeptName(deptName), HttpStatus.OK);
	}

	@GetMapping("/id/{deptNo}")
	public ResponseEntity<Department> getByDeptNum(@PathVariable("deptNo") int deptNo) throws EmployeeException {
		return new ResponseEntity<Department>(departmentService.getByDeptId(deptNo), HttpStatus.OK);
	}

	@DeleteMapping("/{deptNo}")
	public ResponseEntity<Department> deleteByDeptNum(@PathVariable("deptNo") int deptNo) throws EmployeeException {
		departmentService.deleteDepartment(deptNo);
		logger.info("Department Deleted SucessFully");
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
