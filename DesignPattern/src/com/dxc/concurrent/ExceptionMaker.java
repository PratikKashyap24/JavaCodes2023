package com.dxc.concurrent;

public class ExceptionMaker {
public int  add(int a, int b) throws ArithmeticException {
	throw new ArithmeticException("Divide by zero");

}
}
