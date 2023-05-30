package com.dxc.cs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.cs.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
