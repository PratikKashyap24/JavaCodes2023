package com.dxc.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Concureency {
	final int i;
	
public Concureency(int i) {
		super();
		this.i = i;
	}

public static void main(String[] args) {
	@SuppressWarnings("serial")
	CopyOnWriteArrayList<Integer> ls=new CopyOnWriteArrayList<Integer>(){{
		add(10);
		add(20);
		add(30);
		
		
	}};
	
	
	
	for (Iterator<Integer> iterator = ls.iterator(); iterator.hasNext();) {
		Integer integer = (Integer) iterator.next();
		System.out.println(integer);
		
	}
	try {
	ls.remove(5);
	}
	catch (ArrayIndexOutOfBoundsException e) {
		System.out.println(e.getMessage());
	}
	ls.forEach(System.out::println);
}
}
