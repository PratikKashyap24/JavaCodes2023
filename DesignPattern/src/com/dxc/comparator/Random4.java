package com.dxc.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Random4 {
	
	
	public static  void show() throws InterruptedException {
		
	for (int i = 0; i < 100; i++) {
		Thread.sleep(500);
		System.out.println(i); 
		
	}
	}
	
	public static  void show2() throws InterruptedException {
		
		
		for (int i = 0; i < 100; i++) {
			Thread.sleep(500);
			System.out.println(i); 
		}
		}
	
	
	
	
	
public static void main(String[] args) {

//	Ran
//	T1 th1=new T1();
//	T2 thT2=new T2();
//	Thread t1=new Thread(th1);
//	Thread t2=new  Thread(()->{
//		
//		
//		try {
//			show();
//			show2();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//	});
//	
	Thread t1=new Thread(()->{
		try {
			show2();
			show();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
		);

	t1.start();
	//t2.start();
	
	
	
}
}
