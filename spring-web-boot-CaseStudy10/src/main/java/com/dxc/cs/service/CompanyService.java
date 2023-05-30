
  package com.dxc.cs.service;
  
  import java.util.List;
  
  import org.springframework.stereotype.Service;

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;
  
  public interface CompanyService { void addCompany(Company company) throws
  EmployeeException;
  
  List<Company> getAllCompanies() throws EmployeeException;
  }
 