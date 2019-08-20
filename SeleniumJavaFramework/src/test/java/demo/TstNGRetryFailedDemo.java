package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TstNGRetryFailedDemo {
	@Test
	public void testMethod1() {
		System.out.println("Inside testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("Inside testMethod3");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testMethod3() {
		System.out.println("Inside testMethod3");
		Assert.assertTrue(2>5);
	}
}
