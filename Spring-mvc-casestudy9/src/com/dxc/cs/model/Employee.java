package com.dxc.cs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@Column(name = "empId")
	private Integer empId;

	@Column(name = "empName")
	private String empName;

	@Column(name = "compId")
	private Integer compId;

	@Column(name = "gender")
	private String gender;

	public Employee() {
		// Left uimplemented
	}

	public Employee(Integer empId, String empName, Integer compId, String gender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.compId = compId;
		this.gender = gender;
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

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
