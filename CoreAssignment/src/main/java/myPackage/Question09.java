package myPackage;

import java.util.ArrayList;

public class Question09 {
	//isPrime method for question 9
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
			
		for (int i = 2; i < n; i++) {
			if (n%i == 0) {
				return false;
			}
		}
			
		return true;
	}
	
	public static void run() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			al.add(i);
		}
		
		for (int i : al) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
	}
}
