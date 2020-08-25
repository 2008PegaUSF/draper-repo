package myPackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Question20 {
	public static String read(String s) {
		String[] arr = s.split(":");
		System.out.println("Name: " + arr[0] + " " + arr[1]);
		System.out.println("Age: " + arr[2]);
		System.out.println("State: " + arr[3] + " State");
		System.out.println();
		return arr[0];
	}
	
	public static void run() {
		File inFile = new File("Data.txt");
		
		try {
			Scanner input = new Scanner(inFile);
			
			while(input.hasNext()) {
				read(input.nextLine());
			}
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
