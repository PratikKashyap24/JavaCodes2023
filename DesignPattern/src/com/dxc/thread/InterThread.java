package com.dxc.thread;

class Q {
	int num;
    boolean valueSet=false;
	public synchronized void put(int i) throws InterruptedException   {
		while(valueSet) {
			wait();
		}
		System.out.println("Put: " + i);
		this.num = i;
		valueSet=true;
		notify();

	}

	public synchronized void get() throws InterruptedException {
		while(!valueSet) {
			wait();
		}
		System.out.println("Get: " + this.num);
		valueSet=false;
		notify();
	}
}

class Producer implements Runnable {

	Q q;

	public Producer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				q.put(i++);
			} catch (InterruptedException e1) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

class Consumer implements Runnable {

	Q q;

	public Consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				q.get();
			} catch (InterruptedException e1) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

public class InterThread {
	public static void main(String[] args) {

		Q q=new Q();
		new Producer(q);
		new Consumer(q);
	}
}
