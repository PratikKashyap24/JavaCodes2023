package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;

public interface DepartmentService {
	void addDepartment(Department department) throws EmployeeException;

	List<Department> getAllDepartments() throws EmployeeException;
}
