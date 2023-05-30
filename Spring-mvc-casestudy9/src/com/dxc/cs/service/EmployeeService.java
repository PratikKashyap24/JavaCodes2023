package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee() throws EmployeeException;
	void save(Employee employee) throws EmployeeException;
	void update(Employee employee) throws EmployeeException;
	
	void deleteById(Integer empId) throws EmployeeException;
	Employee getById(Integer empId);

}
