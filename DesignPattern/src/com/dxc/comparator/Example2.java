package com.dxc.comparator;

import java.util.Arrays;

public class Example2 {
// www.google.com to com.google.www
	
	
	
	public static void main(String[] args) {
		String s="www.google.com";
		s=s.replace('.','@');
		String arr[]=s.split("@");
		System.out.println(Arrays.toString(arr));
		for (int i = arr.length-1; i >=0; i--) {
			
			System.out.print(arr[i]+ (i!=0?".":""));
		}
	}
}
