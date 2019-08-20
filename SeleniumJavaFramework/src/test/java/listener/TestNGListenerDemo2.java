package listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo2 {
	@Test
	public void test21() {
		System.out.println("Inside test 21");
	}
	@Test
	public void test22() {
		System.out.println("Inside test 22");
		
	}
	@Test
	public void test23() {
		System.out.println("Inside test 23");
		throw new SkipException("");
	}
}
