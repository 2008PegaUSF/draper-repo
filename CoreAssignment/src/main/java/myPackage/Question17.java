package myPackage;

import java.util.Scanner;

public class Question17 {
	public static double calculate(double principal, double rate, double time) {
		return principal * rate * time;
	}
	
	public static void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter principal, rate and time to calculate interest:");
		
		double principal = input.nextDouble();
		double rate = input.nextDouble();
		double time = input.nextDouble();
		
		System.out.println(calculate(principal,rate,time));
		
		input.close();
	}
}
