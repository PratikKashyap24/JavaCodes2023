package com.dxc.comparator;

public class Random {

	public static void main(String[] args) {

		String s = "abccbccba";
		call(s);

//		System.out.println(n);

//			ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)

	}

	private static void call(String s) {
		char[] a = s.toCharArray();
		String n = "";

		if (s != null || s == "") {
			for (int i = 0; i < a.length - 1; i++) {

				if (a[i] == a[i + 1] && i < a.length) {
//				
//				if()

					continue;

				} else {
					n = n + a[i];
				}

			}

			System.out.println(n);
			//call(n);
		}

//		return n;
	}

}
