package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws EmployeeException;

	Employee addEmployee(Employee employee) throws EmployeeException;

	boolean deleteEmployee(int empId) throws EmployeeException;
	
	Employee findByName(String empName) throws EmployeeException;
	
	Employee getById(Integer empId) ;
    Employee update(Employee employee) throws EmployeeException;
}