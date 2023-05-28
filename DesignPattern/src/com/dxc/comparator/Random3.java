package com.dxc.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Random3 {

public static void main(String[] args) {
	List<Integer> list=Arrays.asList(2,3,-3,-4,-9,0,2,3,-4,4,-2);
	int high=list.get(0)*list.get(1);

	for (int i = 2; i < list.size()-1; i++) {
		
		int value=list.get(i)*list.get(i+1);
		if(high<value) {
			high=value;
			
		}
		
		
		
	}
	
	Collections.sort(list);
	
	
	
	
	
	
	
	
	
	
	System.out.println(high);
	
	
	//list.stream().sorted().skip(list.get(high))
	
	

	
	
	
	
	
}
	

	
}