package com.dxc.cs.repository;

import org.springframework.stereotype.Repository;

import com.dxc.cs.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
