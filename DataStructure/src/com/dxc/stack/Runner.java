package com.dxc.stack;

public class Runner {
	public static void main(String[] args) {
		Stack stack = new Stack();
        stack.push(10);
       System.out.println(stack.peek());
        stack.push(20);
        stack.push(30);
        stack.push(40);
      System.out.println(stack.pop());
      System.out.println(stack.peek());
        stack.display();
        
	}
}
