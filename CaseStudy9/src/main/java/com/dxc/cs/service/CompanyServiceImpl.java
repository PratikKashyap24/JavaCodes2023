package com.dxc.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.repository.CompanyRepository;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	
	
	
	public void addCompany(Company company) throws EmployeeException {
		companyRepo.save(company);

	}

	public List<Company> getAllCompanies() throws EmployeeException {

		return companyRepo.findAll();
	}
}
