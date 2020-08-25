package myPackage;

import java.util.*;

public class Question14 {
	
	public static double doMath(Double n) {
		return Math.sqrt(n);	
	}
	
	public static void run() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 1-3");
		int n = input.nextInt();
		
		switch (n) {
			case 1:
				System.out.println("Enter a number to find the square root:");
				double d = input.nextDouble();
				System.out.println(doMath(d));
				break;
			case 2:
				System.out.println(new Date());
				break;
			case 3:
				String[] arr = "I am learning core java".split(" ");
				
				for (String s : arr) {
					System.out.println(s);
				}
				break;
			default:
				System.out.println("Not an option.");
				break;
		}
	}
}
