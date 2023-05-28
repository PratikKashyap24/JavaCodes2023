package com.dxc.comparator;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Random2 {
	


public static void main(String[] args) throws InterruptedException {

	Random2 r=new Random2();
	T1 a=new T1();
	T2 a1=new T2();
//	a.start();
	
//	a1.start();
	
//	ThreadFactory l1=new ThreadFactory() {
//		
//		@Override
//		public Thread newThread(Runnable r) {
//			
//			return null;
//		}
//	};
//	l1.newThread(a);
	ExecutorService ep=Executors.newSingleThreadExecutor();
	ExecutorService ep1=Executors.newFixedThreadPool(2);
//	ExecutorService ep2=Executors.newFixedThreadPool(2);
	
	
//	ep.execute(a);
//	ep.execute(a1);
	ep1.execute(a);
	ep1.execute(a1);
	
	
}
}