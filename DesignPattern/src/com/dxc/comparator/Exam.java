package com.dxc.comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Exam extends Example{
 
	

	 


	public static void main(String[] args) {
		
		
	
		Exam aaa= new Exam();
		System.out.println(aaa.d);
//	Comparator<Integer> comp=new Comparator<Integer>() {
//		
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			if(o1>o2) {
//				return  1;
//			}
//			return 0;
//		}
//	};
//	ArrayList<Integer> list=new ArrayList<>();
//	list.add(10);
//	list.add(100);
//	list.add(1);
//	Collections.sort(list,comp);
//	for (Integer integer : list) {
//		System.out.print(integer+", ");
//	}
	
	
	
	
	
	
	ArrayList<Student> list1=new ArrayList<Student>() {{
		add(new Student(100, "Twinkle"));
		add(new Student(10, "Pratik"));
		add(new Student(1, "abc"));
		add(new Student(2, "xyz"));
	}};
	
	
	for (Student student : list1) {
		list1.add(new Student(2, "xyz"));
	}
	
	
	
	
	
	
	
List l1=	list1.stream().map(s->s.getRollNum()).sorted().skip(1).limit(1).collect(Collectors.toList());

	System.out.println(l1.toString()+"2nd highest");
 Double w=	list1.stream().map(x->x.getRollNum()).mapToInt(x->x).summaryStatistics().getAverage();
 System.out.println(w);
 
   
	List <String> names=list1.stream().map(x->x.getName().toLowerCase()).sorted().collect(Collectors.toList());
	String vc=names.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
	System.out.println(vc);
	System.out.println(names.toString());
	List<Integer> num=list1.stream().map(x->x.getRollNum()).sorted().collect(Collectors.toList());//Sorting
	List<Integer>  secondThhirdHogherst=num.stream().skip(1).limit(2).collect(Collectors.toList());//returning second third higherst
	System.out.println(secondThhirdHogherst.toString());
	int i=list1.stream().mapToInt(x->x.getRollNum()).summaryStatistics().getMax();//Getiing group function using SummaryStatics
	OptionalInt as=list1.stream().mapToInt(x->x.getRollNum()).max();//using group function directly
	System.out.println(Arrays.asList(12,20,1,1).stream().mapToInt(x->x).summaryStatistics().getSum());
    int pi=as.getAsInt();
	System.out.println(pi+"sflsjkj");
	
//	Predicate<Integer> ao=new Predicate<Integer>() {
//		
//		@Override
//		public boolean test(Integer t) {
//			if(t%2==0) {
//				return true;
//			}
//			return false;
//		}
//	};
	Predicate<Integer> ao=(x)->(x%10==0);
	Predicate<Integer> a1=(x)->(x!=10);
	
	System.out.println(a1.and(ao).test(25));
	

	String ahsauj="Pratik";
	
	//Stream.of(ahsauj.toCharArray()).map(c->c.toCharArray()).forEach(c->System.out.println(c));
	char[] ad= {'a','p','d','i','j'};

	Arrays.asList(ahsauj.toCharArray()).stream().map(c->c).skip(1).forEach(c->System.out.println(c));
	
	
//	list1.add(new Student(100, "Twinkle"));
//	list1.add(new Student(10, "Pratik"));
//	list1.add(new Student(1, "abc"));
//	list1.add(new Student(2, "xyz"));
	Comparator<Student> s1=new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.getRollNum()>o2.getRollNum()) {
				return 1;
			}
			return -1;
		}
	};
	Collections.sort(list1,s1);
	
	for (Student student : list1) {
		System.out.println(student);
	}
	
	

	
	
	}
	

	
}

