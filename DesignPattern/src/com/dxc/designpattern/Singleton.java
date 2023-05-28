package com.dxc.designpattern;

import java.io.Serializable;

public class  Singleton extends Thread implements Serializable {

	private Singleton() {
		
	}
	public void display(String s) {
		System.out.println("Count"+s);
	}
	
	private static  Singleton obj;
	
	public static synchronized Singleton getInstance() {
		if(obj==null) {
			System.out.println("Object creation");
			obj= new Singleton();
		}
		
		return  obj;
	}
	@Override
	public void run() {
		System.out.println("Thread running");
	}
	

	
}
