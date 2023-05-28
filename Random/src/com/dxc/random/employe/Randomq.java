package com.dxc.random.employe;

import java.util.function.Predicate;

public class Randomq  {

static {
	System.out.println("pratik");
	//System.exit(0);
}
	public static void main() {
		
	}
	public static void main(String[] args) {
		
		String s1="Pratik";
		s1=s1+" Kashyap";
		System.out.println(s1);
		String s2=new String("pratik");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));		
		Predicate<Integer> i=new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		try{
			System.out.write(32);
		}
		finally {
			
		}
		
	}
	
	
}
