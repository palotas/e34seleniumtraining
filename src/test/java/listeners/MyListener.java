package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Suite has finished");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Suite is starting");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("TEST IS FAILED");
	}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("onStartTest");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TEST IS PASSED");
	}
}
