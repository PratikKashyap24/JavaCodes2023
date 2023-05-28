package TCSSSSS.src;
import java.util.Scanner;

public class Random {
public static void main(String[] args) {
	
	Scanner s=new Scanner(System.in);
	String val=s.nextLine();
	
	char arr[]=val.toCharArray();
	int count =0,count1=0;
	 for(int i=0;i<arr.length;i++)  
     {  
           
         if( ((i>0)&&(arr[i]!=' ')&&(arr[i-1]==' ')) || ((arr[0]!=' ')&&(i==0)) )  
             count1++;  
     }  
     
 
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==' ') {
			continue;
		}
		count++;
	}
	System.out.println(count);
	System.out.println(count1);
}

}
