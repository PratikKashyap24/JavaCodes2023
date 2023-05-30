package com.dxc.cs.service;

import java.util.List;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;

public interface CompanyService {

	void save(Company company) throws EmployeeException;

	List<Company> getAllCompany() throws EmployeeException;
}
