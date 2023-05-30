package com.dxc.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "company")
public class Company implements Serializable {
	
	@Id
	@Column(name="compId")
	
	private Integer compId;
	
	@Column(name = "compName")
	private String compName;
	
	public Company() {
		//Left_uimplemented
	}

	public Company(Integer compId, String compName) {
		super();
		this.compId = compId;
		this.compName = compName;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
	


}
