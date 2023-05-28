import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



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
	Collections.sort(list1);
	
	for (Student student : list1) {
		System.out.println(student);
	}
	
	}
}

