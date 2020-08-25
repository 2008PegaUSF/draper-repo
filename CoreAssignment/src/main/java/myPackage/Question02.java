package myPackage;

public class Question02 {

	public static int run() {
		int a = 0;
		int b = 1;
		int c = 0;
		System.out.print(a + " ");
		System.out.print(b + " ");
		
		for (int i = 0; i < 23; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
		System.out.println();
		
		return c;
	}
}
