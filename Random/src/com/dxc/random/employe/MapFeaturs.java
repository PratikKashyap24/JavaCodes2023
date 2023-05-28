package com.dxc.random.employe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFeaturs {

	public Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
//		  Map<String, List<Employee>> resultMap = new HashMap<>();
//		  for (int i = 0; i < employeeList.size(); i++) {
//		      Employee employee = employeeList.get(i);
//		      List<Employee> employeeSubList = resultMap.getOrDefault(employee.getTitle(), new ArrayList<Employee>());
//		      employeeSubList.add(employee);
//		      resultMap.put(employee.getTitle(), employeeSubList);
//		  }  
//		  return resultMap;
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getTitle));
		}
	public Double avg(List<Employee> emp) {
		
		
		System.out.println(emp.stream().filter(e->e.getSal()>100).filter(e->e.getTitle().equalsIgnoreCase("ECE")).map(e->e.getSal()));
		
		emp.stream().map(e->e.getSal()).distinct().forEach(System.out::println);
		
	
//		
//		int[] result = Arrays.stream(arr1)
//                .mapToInt(arr -> (int) Arrays.stream(arr2)
//                                            .filter(arr2Val -> arr == arr2Val)
//                                            .count())
//                .toArray();
		List<Integer> arr1List = Arrays.asList(10,14,25,36,28,35);
		List<Integer> arr2List = Arrays.asList(10,35,14,36);
		
		
		Integer result = arr1List.stream()
                .map(arr -> (int) arr2List.stream()
                                         .filter(arr2 -> arr==arr2)
                                         .count())
                .mapToInt(Integer::intValue).sum();
		System.out.println(result+"lfjksjf");
//		
		
		
		
		
//		List<Integer> a= new ArrayList<>();
//		for(int i=0;i<array_LEngth;i++) {
//		
//	
//		a.add(Arr[i]);
//		
//		}
//		
//		int sum=0;
//		int avg=0;
//		for(int i=0;i<A.length;i++) {
//			sum+=A[i];
//		}
//		 return sum/A.length;
//		 
	
		 
		return 	emp.stream().mapToInt(e->e.getSal()).average().getAsDouble();	
		
	}
	public static void main(String[] args) {
		MapFeaturs fe=new MapFeaturs();
		List<Employee> list=new ArrayList<Employee>(){ {
			add(new Employee("Eng",1));
			add(new Employee("MEc",1));
			add(new Employee("CSE",1));
			add(new Employee("ECE",101));
			add(new Employee("ECE",101));
		}};
		
		//fe.groupByJobTitle(list);
		Double val=fe.avg(list);
		System.out.println(val);
		
		List<Integer> listada=new ArrayList<Integer>() {{
			add(9);
			add(9);
			add(2);
			add(1);
			add(1);
			add(11);
			
			
			
			
			
		}};
		
		
		
		
		
		
		
		
	}
}
