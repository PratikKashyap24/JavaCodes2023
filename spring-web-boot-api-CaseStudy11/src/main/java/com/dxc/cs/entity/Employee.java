package com.dxc.cs.entity;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private List<Department> deptList = new ArrayList<>();

	public Employee() {
		// left unimplemented
	}

	public Employee(Integer empId, String empName, String gender, int compId, List<Department> deptList) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.compId = compId;
		this.deptList = deptList;
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

	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	

}// end of Employee