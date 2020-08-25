package myPackage;

import java.util.ArrayList;

public class Question19 {
	public static int run() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}
		
		int m = 0;
		for(Integer i : al) {
			if (i % 2 == 0) {
				m += i;
			}
		}
		System.out.println("Sum of evens: " + m);
		
		int n = 0;
		for(Integer i : al) {
			if (i % 2 != 0) {
				n += i;
			}
		}
		System.out.println("Sum of evens: " + n);
		
		for (int i = al.size()-1; i >= 0; i--) {
			if (Question09.isPrime(al.get(i))) {
				al.remove(i);
			}
		}
		System.out.println(al);
		return m;
	}
}
