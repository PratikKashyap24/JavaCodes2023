package com.dxc.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allEmployeesQry", query = "SELECT e from Employee e") })

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	@Id
	@Column(name = "empId")
	private int empId;

	@Column(name = "empName", nullable = false)
	private String empName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "compId", nullable = false)
	private int compId;

	public Employee() {
		// left unimplemented
	}

	public Employee(int empId, String empName, String gender, int compId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.compId = compId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", compId=" + compId + "]";
	}

}// end of Employee