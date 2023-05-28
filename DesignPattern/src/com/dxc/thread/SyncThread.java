package com.dxc.thread;

class Counter {
	int count;

	public synchronized void count() {
		count++;
	}
}

public class SyncThread {
	public static void main(String[] args) throws InterruptedException {
         Counter c1=new Counter();
         Thread t1=new Thread(()->{
        	 for (int i = 0; i < 1000; i++) {
				c1.count();
			}
        	 
         });
         Thread t2=new Thread(()->{
        	 for (int i = 0; i < 1000; i++) {
				c1.count();
			}
        	 
         });
         t1.start();
         t2.start();
         t1.join();
         t2.join();
         System.out.println(c1.count);
         
	}
}
