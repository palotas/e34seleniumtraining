/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static sbox.Settings.HUB;

@Listeners(StatusListenerSbox.class)
public class SboxDemo {

	String ourGroup = "#main-navigation > nav > ul > li:nth-child(1) > a";
	String retail = "#mega-nav-panel > ul > li.col-xs-12.col-sm-9.col-md-9 > ul > li:nth-child(1) > ul > li:nth-child(2) > a";


	@Epic("Lloyds Demo Tests")
	@Feature("Open Lloyds website ")
	@Story("Users should be able to click on the Lloyds website")
	@Severity(SeverityLevel.MINOR)
	@Test(invocationCount = 1, threadPoolSize = 9)
	public void webtest() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "chrome");
		caps.setCapability("e34:token", "617a27e4-c74c-46");
		caps.setCapability("e34:video",true);
		caps.setCapability("e34:l_testName", "Lloyds demo test");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://vm-106.element34.net/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		for (int i= 0; i < 2; i++) {
			driver.get("https://www.lloydsbankinggroup.com/");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(ourGroup)).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(retail)).click();
			Thread.sleep(2000);
		}
		addVideoLink(driver);
		driver.quit();
	}


	@Epic("Lloyds Mobile Tests")
	@Feature("Open Lloyds mobile website ")
	@Story("Users should be able to see the mobile versiob of the Lloyds website")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 1, threadPoolSize = 10)
	public void mobileWebTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability("e34:token", "617a27e4-c74c-46");
		// caps.setCapability("e34:video", true);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		caps.setCapability("e34:l_testName", "mobileWeb  - " + caps.getCapability(MobileCapabilityType.DEVICE_NAME));


		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://www.lloydsbankinggroup.com/");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://www.lloydsbankinggroup.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		driver.quit();
	}

	@Epic("Lloyds Mobile Tests")
	@Feature("Open Lloyds mobile website ")
	@Story("Users should be able to see the mobile version of the Lloyds website on multiple devices")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 1, threadPoolSize = 10, dataProvider = "mobileDataProvider", dataProviderClass = TestData.class)
	public void mobileWebTestWithDataProvider(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("e34:l_testName", "mobileWeb  - " + caps.getCapability(MobileCapabilityType.DEVICE_NAME) + " Android " + caps.getCapability(MobileCapabilityType.PLATFORM_VERSION));

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://www.lloydsbankinggroup.com/");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://www.lloydsbankinggroup.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		driver.quit();
	}





	@Test(invocationCount = 1, threadPoolSize = 10,enabled = false)
	public void nativeAppTest() throws IOException, InterruptedException {
		String appLocation = "http://static.element34.net/mobile/demo_apks/ApiDemos-debug.apk";
		mobileNativeTest(appLocation);
	}

	private void mobileNativeTest(String appLocation) throws MalformedURLException, InterruptedException {
		String threadInfo = String.format("%s - %s", Thread.currentThread().getId(), Thread.currentThread().getName());
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		caps.setCapability("e34:token", "617a27e4-c74c-46");

		caps.setCapability("e34:app", appLocation);
		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "nativeApp " + threadInfo);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");

		AndroidDriver driver = new AndroidDriver(new URL("http://vm-106.element34.net/wd/hub"), caps);
		Wait<AndroidDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.ignoring(NotFoundException.class)
				.ignoring(WebDriverException.class);
		try {
			// For demos, change cycles and sleep so the test takes longer and more containers can be seen in the live view.
			int cycles = 3;
			long sleep = 2000;
			for (int i = 0; i < cycles; i++) {
				MobileElement accessibility = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility"));
				Thread.sleep(sleep);
				accessibility.click();
				Thread.sleep(sleep);
				MobileElement accessibilityService = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
				Thread.sleep(sleep);
				accessibilityService.click();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementById("io.appium.android.apis:id/button"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				MobileElement app = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("App"));
				Thread.sleep(sleep);
				app.click();
				Thread.sleep(sleep);
				MobileElement alertDialogs = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
				Thread.sleep(sleep);
				alertDialogs.click();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("List dialog"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
			}
		} finally {
			driver.quit();
		}
	}





	@Test(enabled = false, dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 40, threadPoolSize = 40)
	public void loadTest(String url) throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "617a27e4-c74c-46");
		options.setCapability("e34:l_testName", "load test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}


	private void addVideoLink(RemoteWebDriver driver) {
		io.qameta.allure.model.Link link = new io.qameta.allure.model.Link();
		link.setName("VIDEO URL");
		link.setUrl(HUB + "/videos/" + driver.getSessionId() + ".mp4");
		Allure.addLinks(link);
	}

}
