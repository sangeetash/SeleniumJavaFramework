package listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo {
	@Test
	public void test1() {
		System.out.println("Inside test 1");
	}
	@Test
	public void test2() {
		System.out.println("Inside test 2");
		Assert.assertTrue(false);
	}
	@Test
	public void test3() {
		System.out.println("Inside test 3");
		throw new SkipException("");
	}
}
