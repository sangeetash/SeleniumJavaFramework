package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	public void onFinish(ITestContext arg0) {
		System.out.println("************Test Completed: "+arg0.getName());
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("************Test Failed: "+arg0.getName());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("************Test Skipped: "+arg0.getName());
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("************Test Started: "+arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("************Test Successful: "+arg0.getName());
		
	}

}
