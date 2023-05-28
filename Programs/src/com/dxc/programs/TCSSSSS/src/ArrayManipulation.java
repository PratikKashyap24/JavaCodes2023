package com.dxc.programs.TCSSSSS.src;

import java.util.Scanner;

public class ArrayManipulation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		Integer len= s.nextInt();
		int[] a= new int[len];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Please Enter the "+i+" value:");
			a[i]=s.nextInt();
		}
		
		
		ArrayManipulator(a);

	}

	static void ArrayManipulator(int[]a) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				int temp=0;
				if(a[i]>a[j]) {
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				}
			}
		}
		
		for (int i : a) {
			System.out.print(i+",");
		}
		int u=10;
		System.out.println(++u);
		
	}
	
}
