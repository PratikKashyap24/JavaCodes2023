package com.dxc.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;
import com.dxc.cs.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void addDepartment(Department department) throws EmployeeException {

 
		departmentRepository.save(department);
	}

	public List<Department> getAllDepartments() throws EmployeeException {

		return departmentRepository.findAll();
	}

}
