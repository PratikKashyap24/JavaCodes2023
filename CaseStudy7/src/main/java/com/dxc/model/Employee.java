package com.dxc.model;

public class Employee {

	private int empId;
	private String empName;
	private String gender;
	private int compId;

	public Employee() {
		// left unimplemented
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
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

	public Employee(int empId, String empName, String gender, int compId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.compId = compId;
	}

	public void onCreate() {
		System.out.println("Bean is created!");
	}

	public void onDestroy() {
		System.out.println("Bean is being destroyed");
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", compId=" + compId + "]";
	}

	
}// end of Employee
