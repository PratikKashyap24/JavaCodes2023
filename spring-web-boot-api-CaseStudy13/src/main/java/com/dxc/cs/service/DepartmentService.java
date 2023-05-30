package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.entity.Department;
import com.dxc.cs.exception.EmployeeException;

public interface DepartmentService {
	Department addDepartment(Department department) throws EmployeeException;

	List<Department> getAllDepartments() throws EmployeeException;
	
	boolean deleteDepartment(int deptId) throws EmployeeException;

	Department findByDeptName(String deptName) throws EmployeeException;

	Department getByDeptId(Integer deptId) throws EmployeeException;
}
