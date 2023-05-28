package com.dxc.comparator;

public class People implements Comparable<People> {

	
	String name;
	Integer age;
	public People(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int compareTo(People o) {
	return	this.age>o.getAge()?1:-1;		
	}
	@Override
	public String toString() {
		return "People [name=" + name + "]";
	}
	
	
	
}
