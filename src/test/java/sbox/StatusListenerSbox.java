/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static elnadv.Helpers.screenshot;
import static sbox.Settings.HUB;

public class StatusListenerSbox implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("[FINISHED]");
	}

	public void onStart(ITestContext ctx) {
		System.out.println("[STARTING EVERYTHING]");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		RemoteWebDriver webDriver = (RemoteWebDriver) ((TestBaseThreadSafe) currentClass).getDriver();

		if (webDriver != null)
		{
			//System.out.println("[FAILED] - TAKING SCREENSHOT");
			screenshot((RemoteWebDriver) webDriver);
			Allure.addAttachment("Video link failed test", "text/uri-list", HUB + "/videos/" + webDriver.getSessionId() + ".mp4");

		}


		}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult result) {
		System.out.println("[STARTING] " + result.getName());
		Object currentClass = result.getInstance();
		RemoteWebDriver webDriver = (RemoteWebDriver) ((TestBaseThreadSafe) currentClass).getDriver();
		Allure.addAttachment("Video link fom listener", "text/uri-list", HUB + "/videos/" + webDriver.getSessionId() + ".mp4");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASSED: " + result.getName());
		System.out.println("Duration " + result.getName() +": "  + (result.getEndMillis() - result.getStartMillis()) + " ms");
	}
}
