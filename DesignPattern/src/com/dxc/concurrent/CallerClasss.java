package com.dxc.concurrent;

public class CallerClasss extends ExceptionMaker {
	
public static void main(String[] args) {
	
	ExceptionMaker call=new ExceptionMaker();
	System.out.println(call.add(2, 4));
}
}
