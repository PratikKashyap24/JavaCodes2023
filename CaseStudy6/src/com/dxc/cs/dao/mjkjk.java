package com.dxc.cs.dao;

public class mjkjk {

	public static void main(String[] args) {
		try {
		int	num3=2/0;
			System.out.println(num3);
		} catch (AbstractMethodError e) {
			System.out.println(e);
		}
	}

}
