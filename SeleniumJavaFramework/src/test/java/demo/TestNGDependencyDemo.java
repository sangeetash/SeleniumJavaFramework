package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	@Test(dependsOnGroups = {"group1"})
	public void testMethod1() {
		System.out.println("Inside testMethod1");
	}
	@Test(groups= {"group1"})
	public void testMethod2() {
		System.out.println("Inside testMethod2");
	}
	@Test
	public void testMethod3() {
		System.out.println("Inside testMethod3");
	}

}
