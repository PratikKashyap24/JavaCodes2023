package com.dxc.cs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "department")

public class Department implements Serializable {

	@Id
	@Column(name = "deptNo")
	private Integer deptNo;

	@Column(name = "deptName", nullable = false)
	private String deptName;

	@Column(name = "empId", nullable = false)
	private int empId;

	public Department() {
		// left unimplemented
	}

	public Department(Integer deptNo, String deptName, int empId) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.empId = empId;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}// end of Department