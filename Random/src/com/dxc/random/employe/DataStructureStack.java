package com.dxc.random.employe;
import java.lang.StackWalker.Option;
import java.util.Scanner;

public class DataStructureStack {
	 int top=-1;
    int  size=0;
	int [] Stack =new int[size];
	
public static void main(String[] args) {
	System.out.println("Enter the Size of Stack: ");
	Scanner s=new Scanner(System.in);
	
	s.nextInt();
	
	int option=0;
	while (option!=4) {
	System.out.println("Enter Your option: "
			+ "Push 1"
			+ "POP 2"
			+ "Peek 3"
			+"Exit 4"
			);
	 option=s.nextInt();
	if(option==1) {
		System.out.println("Enter the element: ");
		int value= s.nextInt();
		DataStructureStack.Push(size,value);
		System.out.println(Stack[0]);
	}
	
	}
	
}

public static String Push(int length,int[] stack,int value) {
	
	if(top==length-1) {
		return "Stack is Full";
				
	}
	
	else {
		top++;
		stack[top]=value;
		return"Pushed";
	}
	
	
	
}





}
