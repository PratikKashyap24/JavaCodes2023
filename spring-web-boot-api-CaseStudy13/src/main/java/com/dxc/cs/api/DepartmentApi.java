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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.cs.entity.Department;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentApi {

	@Autowired
	private DepartmentService departmentService;
      
	private static final Logger logger = LoggerFactory.getLogger("DepartmentApi");
	
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment() throws EmployeeException {
		List<Department> dlist=departmentService.getAllDepartments();
		if(dlist.isEmpty()) {
			return new ResponseEntity<List<Department>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Department>>(dlist, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addDepartment(@Valid @RequestBody Department department, BindingResult bindingResult)
			throws EmployeeException {

		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : bindingResult.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
				logger.error("Cannot add this Department");
			}
			  return new ResponseEntity<String>(errMsg.toString(),HttpStatus.BAD_REQUEST);
			//throw new EmployeeException(errMsg.toString());
		} else {
			departmentService.addDepartment(department);
			logger.info("Department added SucessFully");
			return new ResponseEntity<String>("Department added SucessFully",HttpStatus.OK);
		}

	}

	@GetMapping("/name/{deptName}")

	public ResponseEntity<Department> getByDepartmentName(@PathVariable("deptName") String deptName)
			throws EmployeeException {
		Department  dept=departmentService.findByDeptName(deptName);
		if(dept==null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}

	@GetMapping("/id/{deptNo}")
	public ResponseEntity<Department> getByDeptNo(@PathVariable("deptNo") int deptNo) throws EmployeeException {
		Department dept=departmentService.getByDeptId(deptNo);
	if(dept==null) {
		return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
	}
		
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}

	@DeleteMapping("/{deptNo}")
	public ResponseEntity<String> deleteByDeptNo(@PathVariable("deptNo") int deptNo) throws EmployeeException {
		
		Department dept=departmentService.getByDeptId(deptNo);
		if(dept==null) {
			return new ResponseEntity<String>("Id not found",HttpStatus.NOT_FOUND);
		}
		
		departmentService.deleteDepartment(deptNo);
		logger.info("Department Deleted SucessFully");
		return new ResponseEntity<String>("Department deleted SucessFully",HttpStatus.OK);

	}

}
