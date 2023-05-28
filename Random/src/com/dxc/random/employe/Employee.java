package com.dxc.random.employe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee implements Example,Example2{
	private String Title;
	private Integer sal;
	
	
	public Employee(String title, Integer sal) {
		super();
		Title = title;
		this.sal = sal;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@Override
	public void say() {
		System.out.println("Saying");
		
	}
	public static void Dadad() {
		System.out.println("jdga");
	}
public static void main(String[] args) {
	//Example.Run();
	
	Example2 ty=()->{
		
		System.out.println("Earninggg");
	};
	ty.Earn();
	
	Example ex=Employee::Dadad;
	ex.say();
	
	ArrayList<Integer> ar= new ArrayList<Integer>() {{
		add(10);
		add(3);
		//add(null);
		
	}};
	List<Integer> list=ar.stream().filter(a->a%2==0).collect(Collectors.toList());
	list.forEach(System.out::println);
//	Optional<Integer> op= Optional.ofNullable(ar.get(2)) ;
//	if(op.isPresent()) {
//		System.out.println(" present");
//		
//	}
//	else {
//		System.out.println(" Exception");
//	}
}
@Override
public void Earn() {
	// TODO Auto-generated method stub
	
}
@Override
public String toString() {
	return "Employee [Title=" + Title + ", sal=" + sal + "]";
}




}
