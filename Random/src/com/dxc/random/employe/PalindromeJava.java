package com.dxc.random.employe;

import java.util.Scanner;
public class PalindromeJava {
public static void main(String [] args) {

	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number :");
	int n=s.nextInt();
	s.close();
	boolean rs=isPalindrome(n);
	if(rs==true) {
		System.out.println("Number is palindrome");

	}
	else {
		System.out.println("Number is Not Palindrome");

	}

}
//989

private static boolean isPalindrome(int n) {
	int num=0,x;
	int value=n;
	do {
		x=n%10;
		num=num*10+x;
		n=n/10;
		
	}
	while(n>0);
	if(num==value) {
		return true;
	}
	return false;
}
}