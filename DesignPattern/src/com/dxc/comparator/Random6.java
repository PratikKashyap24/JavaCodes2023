package com.dxc.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Random6 {
public static void main(String[] args) {
	
	List<Integer> list=Arrays.asList(10,20,30);
	
	Set<Integer> set=new HashSet<>();
	
	//List<Integer> ls=list.stream().filter(a->!set.add(a)).collect(Collectors.groupingBy(null));
	
	
	//System.out.println(ls.toString());
	
	byte a=127;
	byte b=127;
	//b=a+b;
	b+=a;
	System.out.println(b);
	
	String s=" I am Pratik";
	
	
	
	String newStr=Stream.of(s).map(sp->new StringBuilder(sp).reverse()).collect(Collectors.joining(" "));
	
	

	System.out.println(newStr);

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
