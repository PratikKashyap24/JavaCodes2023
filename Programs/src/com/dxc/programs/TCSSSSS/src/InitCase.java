import java.util.Scanner;

public class InitCase {

	public static void main(String[] args) {
		System.out.println("Enter the string: ");
		Scanner s= new Scanner(System.in);
		String val =s.nextLine().toLowerCase();
		InitConverter(val);

	}

	
	static void InitConverter(String s) {
		char []a =s.toCharArray();
		a[0]=(char)(a[0]-32);
		for (int i = 1; i < a.length; i++) {
			if(a[i]==' ') {
				a[i+1]=(char)(a[i+1]-32);
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		
		
		
		
	}
}
