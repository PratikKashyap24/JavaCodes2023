import java.util.ArrayList;
import java.util.List;

public class Practice {
	public static void main(String args[]){  
		String a= "i am prtaik";
		String arr[]=a.split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		String[] arra=new String[arr.length];
		List<String> ls =new ArrayList<>();
		int j=0;
		for (int i = arr.length-1; i>=0; i--) {
			
    		//arr[j]=arr[i];
//			aa[j]=arr[i];
//			j++;
			
			arra[j++]=arr[i];
		//	System.out.println();
			ls.add(arr[i]);
		
			System.out.print(arr[i]+" ,");
		}		for (int i = 0; i < arra.length; i++) {
		System.out.print(arra[i]+" ");
	}
	System.out.println(" ");
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i));
		}
	
		}
}