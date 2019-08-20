package demo;

import org.testng.annotations.Test;

@Test(groups = { "classsmoke" })
public class TestNGGroupsDemo {
	@Test(groups = { "sanity", "smoke" })
	public void testMethod1() {
		System.out.println("Inside testMethod1");
	}

	@Test(groups = { "sanity", "regression" })
	public void testMethod2() {
		System.out.println("Inside testMethod2");
	}

	@Test(groups = { "smoke" })
	public void testMethod3() {
		System.out.println("Inside testMethod3");
	}

}
