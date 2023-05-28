package com.dxc.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ShortQuestions {
public static void main(String[] args) {
	
	
//	int arr[] = new int[10];
//	int i=5;
//	arr[i++] = ++i+i++;
//	System.out.println(arr[5]+":"+arr[6]);
//	
//	String test="a1b2c378";
//	String[] tokens =test.split("\\d");
//	for(String s : tokens)
//	System.out.println(s+ " ");
//	
//	 String str = "geekss@for@geekss";
//     String[] arrOfStr = str.split("@");
//
//     for (String a : arrOfStr)
//         System.out.println(a);
//     
//     Character ch = new Character('A');
//     System.out.println(ch+"\t"+(int)ch);
	
String ahsauj="Pratik 892b12@";

//char[] as=ahsauj.toCharArray();
int count=0;
for (int i = 0; i < ahsauj.length(); i++) {
	if(Character.isAlphabetic(ahsauj.charAt(i))) {
		count++;
	}
	//Pattern.matches("[A-Za-z]", ahsauj).;
}
System.out.println(count);


	
	//Stream.of(ahsauj.toCharArray()).map(c->c.toCharArray()).forEach(c->System.out.println(c));
	char[] ad= {'a','p','d','i','j'};
	int[] arr = {1,5,4,3,2};
   List<Integer> list = Arrays.asList(1,2,2,3,0,21,1,1);
//	boolean a=ahsauj.chars().mapToObj(Character::toChars).reduce((v) -> v=='p');
	
	double p=list.stream().sorted().mapToDouble(a->a).summaryStatistics().getSum();
//	System.out.println(sum,"dd");
	
	System.out.println(p);
	
	
	
	
	
	 int[] A = {5, -8, 2, 9, -4, 10, -6,-100}; // sample array
	 
	 for (int i = 0; i < A.length; i++) {
		for (int j = i+1; j < A.length; j++) {
			if(A[i]>A[j]) {
				int temp=0;
				temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
	}
	 
	 
	 
	 
	 System.out.println(Arrays.toString(A));
	 
	 
     int farthestElement = A[0]; 
     
     
     for (int i = 1; i < A.length; i++) {
		
    	 
    	 if(farthestElement<(A[i])) {
    		 
    		 farthestElement=A[i];
    		 
    		 
    	 }
	}
	
	
	
	System.out.println(farthestElement);
	
	
	
	
	
	
	
}
}
