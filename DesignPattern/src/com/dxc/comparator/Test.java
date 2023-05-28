package com.dxc.comparator;

import java.util.Arrays;
import java.util.Iterator;

class  Test {


public static void main(String[] args) {
	//foo(null);
	
	
	String input="This is my name";
	String arr[]=input.split(" ");
	
	String a="";
	for (int i = 0; i < arr.length; i++) {
		StringBuilder sb=new StringBuilder();
		sb.append(arr[i]);
		arr[i]=sb.reverse().toString();
	}
	
	
	String rev="";
	
	for (int i = arr.length-1; i >=0; i--) {
		rev=rev+arr[i]+" ";
	}
	System.out.println(rev);
	
	
	
	System.out.println(Arrays.toString(arr));

	int numArr[]= {1,2,3,0,3,0,4,5,0,0,0};
	
	int max=0;
	for (int i = 0; i < numArr.length; i++) {
		
		if(numArr[i]!=0) {
			
			int temp=0;
			temp=numArr[max];
			numArr[max]=numArr[i];
			numArr[i]=temp;
			max++;
			
		}
		
		
	}
	System.out.println(Arrays.toString(numArr));
	int min=numArr.length-1;
	for (int i = numArr.length-1; i >=0; i--) {
		
		if(numArr[i]!=0) {
			
			int temp=0;
			temp=numArr[min];
			numArr[min]=numArr[i];
			numArr[i]=temp;
			min--;
			
		}
		
		
	}
	
	System.out.println(Arrays.toString(numArr));
	
	
	
	
}

public  static void foo(Integer o) {
	System.out.println("Object");
}
 public static void foo(String s) {
	 System.out.println("String");
 }
}
