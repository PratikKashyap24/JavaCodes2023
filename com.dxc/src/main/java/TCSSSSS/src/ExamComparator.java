package TCSSSSS.src;
import java.util.Comparator;

public class ExamComparator implements Comparator<Integer> {
public int compare(Integer o1, Integer o2) {
System.out.println(o1+"First");
System.out.println(o2+"2nd");
	if(o1>o2) { 
		return -1;
	}
	
	
	return 1;
}
	
	
}
