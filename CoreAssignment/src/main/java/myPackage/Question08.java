package myPackage;

import java.util.ArrayList;

public class Question08 {
	public static boolean isPalindrome(String s) {
		StringBuilder t = new StringBuilder(s);
		t = t.reverse();
		String reverse = t.toString();
		
		if (s.equals(reverse)) {
			return true;
		}
		return false;
	}
	
	public static void run() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
		System.out.print("Palindromes: ");
		
		for (String s : list) {
			if (isPalindrome(s)) {
				palindromes.add(s);
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
}
