package com.dxc.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "department")

public class Department implements Serializable {

	@Id
	@Column(name = "deptNo")
	private Integer deptNo;

	@Column(name = "deptName", nullable = false)
	private String deptName;

	@ManyToOne
	@JoinColumn(name = "employee",referencedColumnName = "empId")
    private Employee employee;

	
	public Department() {
		// left unimplemented
	}

	

	public Department(Integer deptNo, String deptName, Employee employee) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.employee = employee;
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



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

}// end of Department