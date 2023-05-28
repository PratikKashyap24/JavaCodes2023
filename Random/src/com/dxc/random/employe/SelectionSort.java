package com.dxc.random.employe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 7, 2, 8, 8, 9, 4 };
		List<Integer> xy = SelectionSort.SequnceGetter(arr);

		xy.forEach(System.out::println);

	}

	private static List<Integer> SequnceGetter(int[] a) {
		int[] arr = a;

		for (int i = 0; i < arr.length-1; i++) {
			int smallest=i;
			for (int k = i+1; k < arr.length; k++) {
				
				
				if(arr[smallest]>arr[k]) {
					smallest=k;
				}
			}
			int temp = 0;
			temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			
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
