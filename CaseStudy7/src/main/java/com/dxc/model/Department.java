package com.dxc.model;


public class Department  {
	private String deptName;
	private int deptId;
	private int empId;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Department() {
	}
	public Department(String deptName, int deptId, int empId) {
		super();
		this.deptName = deptName;
		this.deptId = deptId;
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + ", empId=" + empId + "]";
	}
	
	
	public void onCreate() {
		System.out.println("Bean is created!");
	}

	public void onDestroy() {
		System.out.println("Bean is being destroyed");
	}

	
}
