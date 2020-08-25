package myPackage;

public class Question13 {
	public static int run() {
		int n = 0;
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(n);
				n = 1 ^ n;
			}
			System.out.println();
		}
		return n;
	}
}
