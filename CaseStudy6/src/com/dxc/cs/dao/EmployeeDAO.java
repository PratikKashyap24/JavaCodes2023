package com.dxc.cs.dao;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.model.Department;
import com.dxc.cs.model.Employee;

public interface EmployeeDAO {

 

    void addEmployee(Employee employee) throws EmployeeException;

 

    void deleteEmployee(int empId) throws EmployeeException;

 

    List<Employee> getAllEmployees() throws EmployeeException;

 

    void addCompany(Company company) throws EmployeeException;

 

    List<Company> getAllCompanies() throws EmployeeException;

 

    void addDepartment(Department department) throws EmployeeException;

 

    List<Department> getAllDepartments() throws EmployeeException;
}// end of EmployeeDAO