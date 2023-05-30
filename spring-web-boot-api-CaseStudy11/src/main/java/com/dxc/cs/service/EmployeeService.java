package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws EmployeeException;

	void addEmployee(Employee employee) throws EmployeeException;

	void deleteEmployee(int empId) throws EmployeeException;
	
	Employee findByName(String empName) throws EmployeeException;
	
	Employee getById(Integer empId) throws EmployeeException;

}