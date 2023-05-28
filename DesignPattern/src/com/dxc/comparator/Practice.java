package com.dxc.comparator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Practice {
public static void main(String[] args) {
	
	
	//Reverse a string at same posistion
	String s="pratik Kashyap is great";
	String arr[]=s.split(" ");
	StringBuilder sb=new StringBuilder();
	for (int i = 0; i < arr.length; i++) {
		
		sb.append(arr[i]);
		
		arr[i]=sb.reverse().toString();
		sb.delete(0, sb.length());
		
		
	}
	System.out.println(Arrays.toString(arr));
	//without String Builder
	
	for (int i = 0; i < arr.length; i++) {
		char a[]=arr[i].toCharArray();
		String x="";
		for (int j= a.length-1; j >=0; j--) {
			x=x+a[j];
		}
		
		arr[i]=x;
		
		
	}
	
	System.out.println(Arrays.toString(arr));
	
	// Count of words in sentence
	
	String word="I am Pratik I am Kashyap Pratik I am";
	
	String brr[]=word.split(" ");
	HashMap<String, Integer> map=new HashMap<>();
	for (int i = 0; i < brr.length; i++) {
		int count =1;
		if(map.containsKey(brr[i])) {
			int n=map.get(brr[i]);
			map.put(brr[i],++n);
		}
		else {
			map.put(brr[i], count);
		}
		
		
	}
	
	
	System.out.println(map.toString());
	
	
	
	
	
}
}
