package TCSSSSS.src;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int arr[]= {23,43,11,10,23,43,56};
		int largest=arr[0];
		int secondlar=arr[0];

		for (int i = 0;i < arr.length;i++) {
			if(arr[i]>largest) {
				secondlar=largest;
				largest=arr[i];
			}	
			else if(arr[i]>secondlar) {
				secondlar=arr[i];
			}

		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		
		System.out.println(secondlar);
		System.out.println(largest);
	}
}
