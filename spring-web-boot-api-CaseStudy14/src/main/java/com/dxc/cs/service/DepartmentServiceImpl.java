package com.dxc.cs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.entity.Department;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	@Override
	public void addDepartment(Department department) throws EmployeeException {

 
		departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() throws EmployeeException {

		return departmentRepository.findAll();
	}

	
	@Override
	public void deleteDepartment(int deptId) throws EmployeeException {

		departmentRepository.deleteById(deptId);
	}
	
	@Override
	public Department findByDeptName(String deptName) throws EmployeeException {
		return departmentRepository.findByDeptName(deptName);
	}
	
	@Override
	public Department getByDeptId(Integer deptId) throws EmployeeException {
		return departmentRepository.findById(deptId).orElse(null);
	}
	
	
	
	
}
