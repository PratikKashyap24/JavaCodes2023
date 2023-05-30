package com.dxc.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allCompanyQry", query = "SELECT c from Company c") })

@Entity
@Table(name = "company")
public class Company implements Serializable {

	@Id
	@Column(name = "compId")
	private int compId;

	@Column(name = "compName", nullable = false)
	private String compName;

	public Company() {
		// left unimplemented
	}

	public Company(int compId, String compName) {
		super();
		this.compId = compId;
		this.compName = compName;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

}// end of Company