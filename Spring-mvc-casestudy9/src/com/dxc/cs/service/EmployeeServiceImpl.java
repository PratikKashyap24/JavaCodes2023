package com.dxc.cs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.dao.EmployeeRepository;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Employee;

@Service
public class EmployeeServiceImpl  implements EmployeeService  {


	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		return (List<Employee>) empRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Employee employee) throws EmployeeException{
		
			empRepo.save(employee);
		
	}
	
	@Override
	public Employee getById(Integer empId) {
		return empRepo.findById(empId).orElse(null);
	}
	
	@Override
	public void deleteById(Integer empId) {
		empRepo.deleteById(empId);	
	}

	@Override
	@Transactional
	public void update(Employee employee) throws EmployeeException {
		empRepo.save(employee);
		
	}
	
}
