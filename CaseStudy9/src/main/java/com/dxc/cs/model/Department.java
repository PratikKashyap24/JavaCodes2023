package com.dxc.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allDeparmentQry", query = "SELECT d from Department d") })

@Entity
@Table(name = "department")
public class Department implements Serializable {

	@Id
	@Column(name = "deptNo")
	private int deptNo;

	@Column(name = "deptName", nullable = false)
	private String deptName;

	@Column(name = "empId", nullable = false)
	private int empId;

	public Department() {
		// left unimplemented
	}

	public Department(int deptNo, String deptName, int empId) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.empId = empId;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
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