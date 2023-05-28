package com.dxc.comparator;

import java.util.HashMap;

public class HashCollision {
public static void main(String[] args) {
	Student s1= new Student(78, "Pratik");
	Student s2= new Student(79, "Kashyap");
	Student s3= new Student(80, "Random");
	Student s4= new Student(81, "Twinkle");
	
	HashMap<Student, String> m1= new HashMap<>();
	m1.put(s1, "1st value");
	m1.put(s1, "2nd value");
	m1.put(s3, "3rd value");
	
	System.out.println();
	System.out.println(m1.get(s1));
	System.out.println(m1.get(s2));
	
	
	
	
	
	
	
	
}
}
