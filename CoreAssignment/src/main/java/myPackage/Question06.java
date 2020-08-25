package myPackage;

public class Question06 {
	//isEven method for question 6
	public static boolean isEven(int i) {
		int j = i/2 + i/2;
		return j == i;
	}
	
	public static void run() {
		System.out.println("Is 52 even: " + isEven(52));
	}
}
