package com.dxc.thread;

import java.util.Arrays;

class Hi1 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Hello1 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemoRunnable {
	public static void main(String[] args) throws InterruptedException {

		Hi1 h = new Hi1();
		Hello1 h2 = new Hello1();

		Thread t1 = new Thread(h, "Hi Thread");
		Thread t2 = new Thread(h2, "Hello Thread");
		t1.setPriority(10);
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		System.out.println(t2.getName());
		System.out.println(t2.getPriority());
		t1.start();
		System.out.println("213");
//		t1.start();
		System.out.println("sdsjd");
		
//		t2.start();
		//Runnable r1 = ;
//		Thread t3=new Thread(() -> {
//			for (int i = 0; i < 5; i++) {
//				System.out.println("last" + i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		});
//		System.out.println(t1.isAlive());
//		t1.join();
//		t2.join();
//        t3.start();
//        System.out.println(t1.isAlive());
	}
}
