package com.dxc.designpattern;

public class MainRunner {
	public static void main(String[] args) throws InterruptedException {
		Singleton s = Singleton.getInstance();
		s.start();
       
		s.display("T1");
//		Singleton s2 = Singleton.getInstance();
//	s2.start();
//
////		s2.display("T2");
////		System.out.println(s.equals(s2));
	}
}
