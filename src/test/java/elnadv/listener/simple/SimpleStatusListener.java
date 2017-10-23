/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.listener.simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static elnadv.Helpers.screenshot;

public class SimpleStatusListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("[FINISHED]");

	}

	public void onStart(ITestContext ctx) {
		System.out.println("[STARTING TEST]");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult result) {
			System.out.println("[FAILED] - please analyze me");
	}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult result) {
		System.out.println("[STARTING] " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASSED: " + result.getName());
		System.out.println("Duration " + result.getName() +": "  + (result.getEndMillis() - result.getStartMillis()) + " ms");
	}
}
