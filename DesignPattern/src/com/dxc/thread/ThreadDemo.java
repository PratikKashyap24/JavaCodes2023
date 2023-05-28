package com.dxc.thread;

class Hi extends Thread {
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

class Hello extends Thread  {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello" + i);
			try {
				Thread.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		Hi h = new Hi();
		Hello h2 = new Hello();
		h.start();
		h2.start();
	}
}
