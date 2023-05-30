package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.dao.EmployeeDAO;
import com.dxc.cs.dao.EmployeeDAOImpl;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.model.Department;
import com.dxc.cs.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl() throws EmployeeException {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public void addEmployee(Employee employee) throws EmployeeException {

		employeeDAO.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(int empId) throws EmployeeException {

		employeeDAO.deleteEmployee(empId);
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {

		return employeeDAO.getAllEmployees();
	}

	@Override
	public void addCompany(Company company) throws EmployeeException {
		employeeDAO.addCompany(company);

	}

	@Override
	public List<Company> getAllCompanies() throws EmployeeException {

		return employeeDAO.getAllCompanies();
	}

	@Override
	public void addDepartment(Department department) throws EmployeeException {

		employeeDAO.addDepartment(department);

	}

	@Override
	public List<Department> getAllDepartments() throws EmployeeException {

		return employeeDAO.getAllDepartments();
	}

}// end of EmployeeServiceImpl