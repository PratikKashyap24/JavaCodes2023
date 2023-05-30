package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws EmployeeException;

	void addEmployee(Employee employee) throws EmployeeException;

	void deleteEmployee(int empId) throws EmployeeException;
	
	Employee findByName(String empName) throws EmployeeException;
	
	Employee getById(Integer empId) throws EmployeeException;

}