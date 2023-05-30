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
	public Employee addEmployee(Employee employee) throws EmployeeException {
   
		System.out.println(employee.getEmpId());
		/*if(employeeRepository.existsById(employee.getEmpId())){
			 throw new EmployeeException("Cannot add Employee");
		
		}*/
		//else {
		employeeRepository.save(employee);
		return employee;
		}
	//}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {

		if (employeeRepository.existsById(empId)) {
			employeeRepository.deleteById(empId);
			return true;
		}
		throw new EmployeeException("Cannot delete Employee");
	}
	
	@Override

	public List<Employee> getAllEmployees() throws EmployeeException {

		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findByName(String empName) throws EmployeeException {
		return employeeRepository.findByEmpName(empName);
	}
	@Override
	public Employee getById(Integer empId)  {
		return employeeRepository.findById(empId).orElse(null);
	}
	
	@Override
	public Employee update(Employee employee) throws EmployeeException {

		return employeeRepository.save(employee);
	}

}// end of EmployeeServiceImpl