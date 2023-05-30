package com.dxc.cs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")

public class Employee implements Serializable {

	@Id
	@Column(name = "empId")
	private Integer empId;

	@Column(name = "empName", nullable = false)
	private String empName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "compId", nullable = false)
	private int compId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee", targetEntity = Department.class)
	private List<Department> deptList = new ArrayList<>();

	public Employee() {
		// left unimplemented
	}

	public Employee(Integer empId, String empName, String gender, int compId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.compId = compId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
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