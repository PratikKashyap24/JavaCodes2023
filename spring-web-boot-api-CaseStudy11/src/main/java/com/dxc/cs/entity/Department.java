package com.dxc.cs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "department")

public class Department implements Serializable {

	@Id
	@Column(name = "deptNo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptNo;

	@Column(name = "deptName", nullable = false)
	private String deptName;

	

	
	public Department() {
		// left unimplemented
	}

	

	public Department(Integer deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
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


}// end of Department