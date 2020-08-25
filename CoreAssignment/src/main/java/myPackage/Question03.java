package myPackage;

public class Question03 {

	public static String run() {
		String s = "A santa spits tips at Nasa";
		String t = "";
		
		System.out.println(s);
		
		for (int i = s.length() - 1; i >= 0; i--) {
			t += s.charAt(i);
		}
		
		System.out.println(t);
		
		return t;
	}

}
