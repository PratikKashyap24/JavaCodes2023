package com.dxc.cs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	@Override
	public void addEmployee(Employee employee) throws EmployeeException {

		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) throws EmployeeException {

		employeeRepository.deleteById(empId);
		;
	}
	
	@Override

	public List<Employee> getAllEmployees() throws EmployeeException {

		return employeeRepository.findAll();
	}

}// end of EmployeeServiceImpl