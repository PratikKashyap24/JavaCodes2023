package com.dxc.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.cs.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
