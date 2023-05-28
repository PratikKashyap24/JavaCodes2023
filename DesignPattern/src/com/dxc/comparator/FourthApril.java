package com.dxc.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourthApril {
public static void main(String[] args) {
	
	Map<Integer, String> sp=new HashMap<>();
	sp.put(20, "Pratik Kashyap");
	sp.put(121, "random");
	
	ArrayList<Integer> ap=new ArrayList<Integer>() {{
		
		add(1);
		add(0);
		add(23);
		add(2);
		add(100);
		
		
		
	}};
	class Emp implements Comparable<Emp>{
		String name;
		Integer id;
		public Emp(String name, Integer id) {
			super();
			this.name = name;
			this.id = id;
		}
		@Override
		public String toString() {
			return "Emp [name=" + name + ", id=" + id + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		@Override
		public int compareTo(Emp o) {
			return this.id>o.getId()?1:-1;
			
		}
		
		
	}
	ArrayList<Emp> ui=new ArrayList<Emp>() {{
		
		add(new Emp("Pratik", 20));
		add(new Emp("Kashyap", 10));
		add(new Emp("Random", 10));
		add(new Emp("Exc", 2));
		

	}};
	
	
	
	
	
	List<Emp> qw=ui.stream().filter(a->a.getId()>2).sorted((e1,e2)->e1.getId()>e2.getId()?1:-1).collect(Collectors.toList());
	System.out.println(qw.toString());
	
	
//	Map<Integer, List<Emp>> gb=ui.stream().collect(Collectors.groupingBy(a->a.getId()));
//	System.out.println(gb.toString());
	
	
	Map<Integer, List<Emp>> gb=ui.stream().map(a->a.getId()).max((a,b)->a>b?1:-1)..collect(Collectors.groupingBy(a->a.getId()));
	System.out.println(gb.toString());
	
	Integer qa=ap.stream().filter(a->a%2==0).mapToInt(a->a).sum();
	
	
	
     System.out.println(qa);
	
	
	for (Entry<Integer, String> op : sp.entrySet()) {
		
		System.out.println(op.getKey()+" "+op.getValue());
		
		
	}
	
	String fg="Pratik Kashyap";
	List<String> iq=Stream.of(fg).collect(Collectors.toList());
	System.out.println(fg.toString()+"ansk");
	
	int Arr[]= {10,20,30,40,50};
	int k[]=new int[Arr.length];
	int q=0;
	for (int i = 0 ,j=Arr.length-1; i <=j; i++,j--) {
		k[q++]=Arr[i];
		if(q<Arr.length)
		k[q++]=Arr[j];
		
		
		
	}
	System.out.println(Arrays.toString(k));
	
	
	
	StringBuilder sb=new StringBuilder();
	sb.append("pratik");
	sb.append("kashyap");
	
	System.out.println(sb.indexOf("pratik"));
	
	
	
	int arrq[]= {10,11,11,20,1,16,5};
	int sum=21;
	
	for (int i = 0; i < arrq.length; i++) {
		
		int numTo=sum-arrq[i];
		for (int j = i+1; j < arrq.length; j++) {
			
			if(arrq[j]==numTo) {
				System.out.println(arrq[i]+" "+arrq[j]);
				
			}
		}
	}
	
	
//	Map<Integer, Integer> us=new HashMap<>();
//	
//	for (int i = 0; i < arrq.length; i++) {
//		us.put(i, arrq[i]);
//	}
//	
//	for (int i = 0; i < arrq.length; i++) {
//		int numTo=sum-arrq[i];
//		
//		if(us.containsValue(numTo)&&!us.containsKey(i)) {
//			System.out.println(arrq[i]+numTo);
//		}
//		
//	}
	
	
}
}
