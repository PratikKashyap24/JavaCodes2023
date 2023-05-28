package com.dxc.random.employe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 7, 2, 8, 8, 9, 4 };
		List<Integer> xy = BubbleSort.SequnceGetter(arr);

		xy.forEach(System.out::println);

	}

	private static List<Integer> SequnceGetter(int[] a) {
		int[] arr = a;

		for (int i = 0; i < arr.length-1; i++) {
			for (int k = 0; k < arr.length-i-1; k++) {
				int temp = 0;
				if (arr[k] > arr[k+1]) {
					temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}

			}
		}
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> listArr = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (i > 0 && arr[i] == arr[i - 1] + 1) {
				listArr.add(arr[i]);
				count++;
			}

		}

		System.out.println("Largest Count" + count);

		return listArr;
	}

}
