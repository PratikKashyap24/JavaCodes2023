
package com.dxc.cs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepo;

	@Transactional

	@Override
	public void addCompany(Company company) throws EmployeeException {
		companyRepo.save(company);

	}

	@Override
	public List<Company> getAllCompanies() throws EmployeeException {

		return companyRepo.findAll();
	}
	
	@Override
	public void deleteCompany(int compId) throws EmployeeException {
           companyRepo.deleteById(compId);;		
	}
	
	@Override
	public Company findByCompName(String compName) throws EmployeeException {
		return companyRepo.findByCompName(compName);
	}
	@Override
	public Company getByCompId(Integer compId) throws EmployeeException {
		return companyRepo.findById(compId).orElse(null);
	}
	
	@Override
	public void update(Company company) throws EmployeeException {

		companyRepo.save(company);
	}
	
}
