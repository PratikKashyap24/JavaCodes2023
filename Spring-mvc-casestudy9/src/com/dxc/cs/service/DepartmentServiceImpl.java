package com.dxc.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.dao.DepartmentRepository;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository depRepo;

	@Override
	public void save(Department department) throws EmployeeException {

		depRepo.save(department);

	}

	@Override
	public List<Department> getAllDepartment() throws EmployeeException {
		return depRepo.findAll();
	}

}
