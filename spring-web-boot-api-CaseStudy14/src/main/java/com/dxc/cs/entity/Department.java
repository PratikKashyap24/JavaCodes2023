package com.dxc.cs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "department")
@SequenceGenerator(name="seq", initialValue=1000, allocationSize=2000)
public class Department implements Serializable {

	@Id
	@Column(name = "deptNo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@NotNull(message = "Dept Number  cannot be null")
	private Integer deptNo;

	@Column(name = "deptName", nullable = false)
	@NotBlank(message = "Dept Name cannot bbe blank")
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