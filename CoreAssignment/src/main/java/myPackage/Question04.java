package myPackage;

public class Question04 {
	//Factorial method for question 4
	public static int factorial(int n) {
		if (n > 1) {
			return n * factorial(n-1);
		}
		return 1;
	}
	
	public static void run() {
		System.out.println("Factorial of 10: " + factorial(10));
	}
}
