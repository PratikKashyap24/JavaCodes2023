package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.entity.Department;
import com.dxc.cs.exception.EmployeeException;

public interface DepartmentService {
	void addDepartment(Department department) throws EmployeeException;

	List<Department> getAllDepartments() throws EmployeeException;
}
