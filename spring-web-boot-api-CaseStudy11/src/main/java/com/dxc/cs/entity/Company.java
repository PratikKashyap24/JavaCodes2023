
package com.dxc.cs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "company")

public class Company implements Serializable {

	@Id
    @Column(name = "compId")
	private Integer compId;

	@Column(name = "compName", nullable = false)
	private String compName;

	public Company() { // left unimplemented
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

}// end of Company
