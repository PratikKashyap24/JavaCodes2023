package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;

public interface DepartmentService {

	void save(Department department) throws EmployeeException;
	List<Department> getAllDepartment() throws EmployeeException;
	
	
}
