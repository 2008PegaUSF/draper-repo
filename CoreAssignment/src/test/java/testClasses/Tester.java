package testClasses;

import org.junit.jupiter.api.*;

import myPackage.*;
import myPackage.Question07.Employee;

public class Tester {
	
	@Test
	public void test1() {
		int[] arr = {1,2,3,4,5};
		int[] unarr = {5,2,3,1,4};
		Assertions.assertArrayEquals(arr, Question01.sort(unarr));
	}
	
	@Test
	public void test2() {
		Assertions.assertEquals(46368, Question02.run());
	}

	@Test
	public void test3() {
		Assertions.assertEquals("asaN ta spit stips atnas A", Question03.run());
	}
	
	@Test
	public void test4() {
		Assertions.assertEquals(120, Question04.factorial(5));
	}
	
	@Test
	public void test5() {
		Assertions.assertEquals("ell", Question05.substring("Hello", 1, 3));
	}
	
	@Test
	public void test6() {
		Assertions.assertTrue(Question06.isEven(100));
	}
	
	@Test
	public void test7() {
		Employee e = new Employee("Dave", "IT", 22);
		Employee f = new Employee("Alex", "Accounting", 23);
		
		Employee[] unarr = {e,f};
		Employee[] arr = {f,e};
		
		Assertions.assertArrayEquals(arr, Question07.sort(unarr));
	}
	
	@Test
	public void test8() {
		Assertions.assertTrue(Question08.isPalindrome("racecar"));
	}
	
	@Test
	public void test9() {
		Assertions.assertTrue(Question09.isPrime(13));
	}
	
	@Test
	public void test10() {
		Assertions.assertEquals(3, Question10.run());
	}
	
	@Test
	public void test11() {
		Assertions.assertEquals(11.6f, Question11.run());
	}
	
	@Test
	public void test12() {
		Assertions.assertFalse(Question12.isEven(13));
	}
	
	@Test
	public void test13() {
		Assertions.assertEquals(0, Question13.run());
	}
	
	@Test
	public void test14() {
		Assertions.assertEquals(5.0, Question14.doMath(25.0));
	}
	
	@Test
	public void test15() {
		Question15Implementation q = new Question15Implementation();
		Assertions.assertEquals(15, q.multiplication(3, 5));
	}
	
	@Test
	public void test16() {
		Assertions.assertEquals(4, Question16.main("Java"));
	}
	
	@Test
	public void test17() {
		Assertions.assertEquals(10, Question17.calculate(200, .05, 1));
	}
	
	@Test
	public void test18() {
		Question18Implementation q = new Question18Implementation();
		Assertions.assertTrue(q.findCapitalLetters("Hello World!"));
	}
	
	@Test
	public void test19() {
		Assertions.assertEquals(30,Question19.run());
	}
	
	@Test
	public void test20() {
		Assertions.assertEquals("Mickey", Question20.read("Mickey:Mouse:35:Arizona"));
	}
}
