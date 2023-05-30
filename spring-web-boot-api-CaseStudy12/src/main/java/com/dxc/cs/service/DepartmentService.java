package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;

public interface DepartmentService {
	void addDepartment(Department department) throws EmployeeException;

	List<Department> getAllDepartments() throws EmployeeException;
	
	void deleteDepartment(int deptId) throws EmployeeException;

	Department findByDeptName(String deptName) throws EmployeeException;

	Department getByDeptId(Integer deptId) throws EmployeeException;
}
