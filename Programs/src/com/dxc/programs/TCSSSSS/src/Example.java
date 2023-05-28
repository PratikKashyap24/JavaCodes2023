import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Example {
	int d=10;
	

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String val = s.next();
		char charValue = s.next().charAt(0);
		Object a=CharCounter(val, charValue);

		
		
		
	}
	public void show() {
		System.out.println("In Example");
	}

	static Object CharCounter(String value, char charvalue) {
		//int count = 0;
		Map<Character, Integer> k = new HashMap<>();
		char[] var = value.toCharArray();
		for (int i = 0; i < var.length; i++) {
			int count = 0;
			if(!k.containsKey(var[i])) {
			for (int j = i + 1; j < var.length; j++) {
				System.out.println(var[j]);
				if(var[i]==var[j]) {
					count++;
					
				}
				
				
			}
			
			k.put(var[i], count);
			count=0;
			}
			else {
			
				k.put(var[i], k.get(var[i])+1);
			}
			//System.out.println(var[i]+" "+count);
			

		}
		int i=50;
	
		
		
		System.out.println(k.toString());

//	for (char c : var) {
//		if(c==charvalue) {
//			count++;
//		}
		LinkedList<Integer> a =new LinkedList<>();
		a.add(5);
		a.add(2);
		a.add(1,90);
		for (Integer integer : a) {
			System.out.println(integer);
		}
	
		
		
//	}
		
		Integer ia=10;
		String g="ada";
		
		
		
	
		
return Integer.valueOf(10);
		
		

	}
}
