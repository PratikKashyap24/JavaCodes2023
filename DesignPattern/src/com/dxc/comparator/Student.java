package com.dxc.comparator;

import java.util.Objects;

public class Student  implements Comparable<Student> {
 int rollNum;
	String name; 
	public int getRollNum() {
		return rollNum;
	}@Override
	public int compareTo(Student o) {
		return this.rollNum>o.getRollNum()?1:-1;
		
	}
	protected Object  setRollNum(int rollNum) {
		this.rollNum = rollNum;
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + "]";
	}
	public Student(int rollNum, String name) {
		super();
		this.rollNum = rollNum;
		this.name = name;
	}
	@Override
	public int hashCode() {
	//	return Objects.hash(name, rollNum);
		final int num=12;
		return num;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && rollNum == other.rollNum;
	}
	
	

}
