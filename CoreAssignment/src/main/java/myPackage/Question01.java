package myPackage;

public class Question01 {
	public static int[] sort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			//System.out.println("i: " + i);
			for (int j = 0; j < i; j++) {
				//System.out.println("j: " + j);
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public static void run() {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] sortedArray = sort(arr);
		
		for (int i : sortedArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
