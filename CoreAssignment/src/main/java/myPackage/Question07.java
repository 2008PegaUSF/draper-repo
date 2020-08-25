package myPackage;

import java.util.Comparator;

public class Question07 {
	public static class Employee implements Comparator<Employee>{
		String name;
		String department;
		int age;
		
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public int compare(Employee e, Employee f) {
			int a = compare(e.name,f.name);
			int b = compare(e.department, f.department);
			
			if (a != 0) return a;
			if (b != 0) return b;
			
			return compare(e.age,f.age);
		}
		
		public int compare(String s, String t) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) > t.charAt(i)) {
					return 1;
				} else if (s.charAt(i) < t.charAt(i)) {
					return -1;
				}
			}
			return 0;
		}
		
		public int compare(Integer i, Integer j) {
			return i - j;
		}
	}
	
	public static Employee[] sort(Employee[] arr) {
		
		for (int i = arr.length - 1; i >= 0; i--) {
			//System.out.println("i: " + i);
			for (int j = 0; j < i; j++) {
				//System.out.println("j: " + j);
				if (arr[j].compare(arr[j],arr[j+1]) == 1) {
					Employee temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public static void run() {
		Employee[] arr = {
							new Employee("Dave", "IT", 22),
							new Employee("Alex", "Accounting", 23)	
						};
		
		sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			Employee e = arr[i];
			System.out.println(e.name + " " + e.department + " " + e.age);
		}
		
	}
	
}
