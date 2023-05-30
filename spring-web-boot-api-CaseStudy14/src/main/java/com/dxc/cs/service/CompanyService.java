
package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;

public interface CompanyService {

	void addCompany(Company company) throws EmployeeException;

	List<Company> getAllCompanies() throws EmployeeException;

	void deleteCompany(int compId) throws EmployeeException;

	Company findByCompName(String compName) throws EmployeeException;

	Company getByCompId(Integer compId) throws EmployeeException;
	
	void update(Company company) throws EmployeeException;

}
