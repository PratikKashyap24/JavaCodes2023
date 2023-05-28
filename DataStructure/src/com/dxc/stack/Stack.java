package com.dxc.stack;


public class Stack {
 
	int arr[] =new int[10];
	int top=-1;
	
	public void push(int value) {
		top++;
       arr[top]=value;
	
	}

	public int pop() {
		if(top==-1) {
			System.out.println("Stack is Empty");
			return 0;
		}
		else {
			
			int x=arr[top];
			arr[top]=0;
			top--;
			return x;
		}
		
		
		
	}

	public int peek() {
		
		return arr[top];
	}
	public void display() {
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

}
