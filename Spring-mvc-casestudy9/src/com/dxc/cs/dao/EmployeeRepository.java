package com.dxc.cs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.cs.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
