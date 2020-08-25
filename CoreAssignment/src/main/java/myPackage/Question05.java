package myPackage;

public class Question05 {
	//Substring method for question 5
	public static String substring(String s, int m, int n) {
		String t = "";
		
		for(int i = m; i <= n; i++) {
			t += s.charAt(i);
		}
		
		return t;
	}
	
	public static void run() {
		String s = "Hello";
		System.out.println("Substring of " + s + " (1,3): " + substring(s,1,3));
	}
}
