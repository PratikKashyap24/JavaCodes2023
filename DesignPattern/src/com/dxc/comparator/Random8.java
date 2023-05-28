package com.dxc.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Random8{


	public static void main(String[] args) {
		
		String s="Rohit Virat Rohit XYZ Virat";
		
		String [] arr=s.split(" ");
		
		Map<String, Integer> map=new HashMap<>();
		
		
		for (int i = 0; i < arr.length; i++) {
			
			if(!map.containsKey(arr[i])) {
				
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], map.get(arr[i])+1);
			}
			
			
		}
		
		System.out.println(map.toString());
		
	
	}
}