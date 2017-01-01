package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.DoScreenshot;

import java.io.IOException;
import java.util.Objects;

public class StatusListener implements ITestListener {

	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext ctx) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed --> taking screenshot");
		Object currentClass = result.getInstance();
		RemoteWebDriver driver = ((ListenerTest) currentClass).getDriver();
		try {
			DoScreenshot.takeScreenshotNoReport(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASSED: " + result.getName());
		System.out.println("Duration of " + result.getName() +": "  + (result.getEndMillis() - result.getStartMillis()));


	}
}
