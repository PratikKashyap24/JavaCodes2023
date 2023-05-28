package TCSSSSS.src;
import java.util.Scanner;

public class factor {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int num=s.nextInt();
	for(int i=2;i<num;i++) {
	
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2||count==1) {
				System.out.print(i +" ");
				count=0;
			}
			else {
				count=0;
			}
		
		
	}
}
}
