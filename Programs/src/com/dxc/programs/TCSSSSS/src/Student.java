
public class Student  implements Comparable<Student> {
	int rollNum;
	String name;
	public int getRollNum() {
		return rollNum;
	}@Override
	public int compareTo(Student o) {
		return this.rollNum>o.getRollNum()?1:-1;
		
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + "]";
	}
	public Student(int rollNum, String name) {
		super();
		this.rollNum = rollNum;
		this.name = name;
	}
	

}
