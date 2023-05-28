package com.dxc.interfaceSegregation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.Predicate;

public class RunnerSegregator extends Employee implements Department {


	public RunnerSegregator(int i) {
		super(i);
	}
	public RunnerSegregator() {
		super(0);
	}

	@Override
	public void show() throws FileNotFoundException {
		System.out.println("Show");

	}

	public static void main(String[] args) throws IOException {
		Predicate<Integer> ip=(i)->(i%2==0);
		System.out.println(ip.test(5));
		RunnerSegregator r = new RunnerSegregator();
		r.show();
		System.out.println(r.i);
		
		Employee e=new Employee(6) {
    
			@Override
			void Implemnt() {
				System.out.println("skfsn");
				
			}
	};
	
//		Employee e = new RunnerSegregator(1);
		e.Implemnt();
		e.showAbs();
		System.out.println(e.j);
		System.out.println(e.k);
		
		Department d=new RunnerSegregator();
		d.show();

	}

	@Override
	void Implemnt() {
		System.out.println("sfknsj");

	}

}