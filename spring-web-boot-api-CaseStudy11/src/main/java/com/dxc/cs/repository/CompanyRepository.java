
package com.dxc.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.cs.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Company findByCompName(String compName);

}
