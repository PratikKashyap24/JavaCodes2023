package com.dxc.random.employe;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Joiner {
	public static void main(String[] args) {
		StringJoiner a=new StringJoiner(",");
		a.add("Prtaik");
		a.add("Kashyap");
		System.out.println(a);
		
		List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
		
		List<String> list=productsList.stream().map(x->x.name).collect(Collectors.toList());
		System.out.println(list.toString());
		
		
		
		
		
		
		
		
		
		
		
	}


}
