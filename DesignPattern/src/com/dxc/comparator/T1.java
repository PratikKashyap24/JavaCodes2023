package com.dxc.comparator;

import java.util.Vector;

class T1 implements Runnable{
	
	Vector<Integer> v1=new Vector<>();
	
	
	@Override
	public void run() {
		
		
		v1.add(1);
		v1.add(2);
		
		
		System.out.println(v1.toString());
//		for (int i = 0; i <100; i++) {
//			
//			if(i%2==0)
//				
//			System.out.print(i+" ,");
////		try {
////			//Thread.sleep(1000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		}
	}
	
}

