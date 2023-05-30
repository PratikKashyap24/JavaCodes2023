package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.model.Department;
import com.dxc.cs.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws EmployeeException;

	void addCompany(Company company) throws EmployeeException;

	List<Company> getAllCompanies() throws EmployeeException;

	void addDepartment(Department department) throws EmployeeException;

	List<Department> getAllDepartments() throws EmployeeException;

	void addEmployee(Employee employee) throws EmployeeException;

	void deleteEmployee(int empId) throws EmployeeException;

}