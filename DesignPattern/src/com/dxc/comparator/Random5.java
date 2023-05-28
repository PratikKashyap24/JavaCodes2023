package com.dxc.comparator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Random5 {
public static void main(String[] args) {
	Map<String, List<String>> listOfPeople = new HashMap<>(); 
	listOfPeople.put("Yash", Arrays.asList("123456789", "5553389")); 
	listOfPeople.put("Akisha", Arrays.asList("5552243", "5555264")); 
	listOfPeople.put("Aanchal", Arrays.asList("5556654", "5553242"));
	
	
	List<String> ls=listOfPeople.entrySet().stream().map(s->s.getValue()).flatMap(a->a.stream()).collect(Collectors.toList());
	System.out.println(ls.toString());
	
	
	
	
	
	
	
	
	
}
}
