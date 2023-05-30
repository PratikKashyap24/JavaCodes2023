
package com.dxc.cs.service;

import java.util.List;


import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;

public interface CompanyService {

	void addCompany(Company company) throws EmployeeException;

	List<Company> getAllCompanies() throws EmployeeException;

	void deleteCompany(int compId) throws EmployeeException;

	Company findByCompName(String compName) throws EmployeeException;

	Company getByCompId(Integer compId) throws EmployeeException;

}
