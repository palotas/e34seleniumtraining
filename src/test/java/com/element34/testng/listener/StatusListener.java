package com.element34.testng.listener;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.DoScreenshot;

public class StatusListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("[FINISHED]");

	}

	public void onStart(ITestContext ctx) {
		System.out.println("[STARTING EVERYTHING]");
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
