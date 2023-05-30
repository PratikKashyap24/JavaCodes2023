package com.dxc.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.dao.CompanyRepository;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository compRepo;

	@Override
	public void save(Company company) throws EmployeeException {

		compRepo.save(company);
	}

	@Override
	public List<Company> getAllCompany() throws EmployeeException {
		
		return compRepo.findAll();
	}

}
