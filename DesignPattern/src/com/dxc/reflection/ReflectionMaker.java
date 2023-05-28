package com.dxc.reflection;

public class ReflectionMaker {
	String name="Pratik";
	Integer id;
	private String getName() {
		System.out.println(name);
		return name;
	}
	 ReflectionMaker() {
		
	}
	private String setName() {
		this.name = "aldjk";
		System.out.println("Twinke"+getName());
		return name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ReflectionMaker(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	

}
