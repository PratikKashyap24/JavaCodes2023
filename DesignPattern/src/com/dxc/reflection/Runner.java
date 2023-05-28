package com.dxc.reflection;

import java.lang.reflect.Method;

public class Runner {
	public static void main(String[] args) throws Exception {

		Class r=Class.forName("com.dxc.reflection.ReflectionMaker");
		ReflectionMaker rm=(ReflectionMaker)r.newInstance();
		Method m=r.getDeclaredMethod("setName",null);
//		Constructor c=r.getConstructor();
//		c.setAccessible(true);
	    m.setAccessible(true);
	    System.out.println(m.invoke(rm));
	   // System.out.println(c.);
	   
	  
		//System.out.println(r.getName());
	}
}
