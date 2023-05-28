package TCSSSSS.src;
public class Wordcount {
	static int wordcount(String string) {
		int count = 0;

		//System.out.println(string.trim());

		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {

			ch[i] = string.charAt(i);
			if(ch[i]==' ') {
				
			}
			
				
			
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		for (char c : ch) {
			System.out.print(c+",");
		}
		return count;
	}

	public static void main(String[] args) {
		String string = "India   Is My Country";
		System.out.println(wordcount(string) + " words.");
	}
}