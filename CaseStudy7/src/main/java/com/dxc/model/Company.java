package com.dxc.model;

public class Company  {
	private int compId;
	private String compName;

	

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

	public Company(int compId, String compName) {
		super();
		this.compId = compId;
		this.compName = compName;
	}

	public Company() {
	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + "]";
	}
	public void onCreate() {
		System.out.println("Bean is created!");
	}

	public void onDestroy() {
		System.out.println("Bean is being destroyed");
	}

}
