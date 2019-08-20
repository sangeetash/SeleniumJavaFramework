package demo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {
	@Test(priority =3)
	public void test1() {
		System.out.println("Test method 1");
	}
	@Test(priority = 0)
	public void test2() {
		System.out.println("Test method 2");
	}
	@Test(priority = 1)
	public void test3() {
		System.out.println("Test method 3");
	}

}
