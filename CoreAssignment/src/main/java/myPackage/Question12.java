package myPackage;

public class Question12 {
	public static boolean isEven(int i) {
		if (i%2 == 0) return true;
		return false;
	}
	
	public static void run() {
		int[] array = new int[100];
		for(int i = 0; i < 100; i++) {
			array[i] = i+1;
		}
		
		for (int i : array) {
			if (isEven(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
	}
}
