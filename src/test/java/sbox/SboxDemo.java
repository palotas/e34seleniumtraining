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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static sbox.Settings.HUB;

public class SboxDemo {




	@Epic("Selenium Box Demo Tests")
	@Feature("Open website ")
	@Story("Users should be able to click on the website")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void webtest() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "chrome");
		caps.setCapability("e34:token", "aa43a67a-0303-4e");
		caps.setCapability("e34:video",true);
		caps.setCapability("e34:l_testName", "Selenium Box demo test");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://vm-106.element34.net/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);

		for (int i= 0; i < 5; i++) {
			driver.get("https://www.jpmorganchase.com/");
			Thread.sleep(2000);
			driver.findElement(By.id("searchTextField")).sendKeys(Keys.chord("Gold" + Keys.ENTER));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("matched-documents")));
			Assert.assertEquals(driver.findElement(By.id("matched-documents")).getText(), "Your search matched 69 documents.");

			Thread.sleep(2000);

		}

		addVideoLink(driver);
		driver.quit();
	}


	@Test(enabled = true, dataProvider = "browserProvider", dataProviderClass = TestData.class)
	public void webTestWithMultipleBrowsers(DesiredCapabilities caps) throws IOException, InterruptedException {

		caps.setCapability("e34:token", "aa43a67a-0303-4e");
		caps.setCapability("e34:video",true);
		caps.setCapability("e34:l_testName", "SBOX multi browser test");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://vm-106.element34.net/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		for (int i= 0; i < 5; i++) {
			driver.get("https://www.jpmorganchase.com/");
			Thread.sleep(2000);
			driver.findElement(By.id("searchTextField")).sendKeys(Keys.chord("Gold" + Keys.ENTER));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("matched-documents")));
			Assert.assertEquals(driver.findElement(By.id("matched-documents")).getText(), "Your search matched 69 documents.");

			Thread.sleep(2000);

		}
		addVideoLink(driver);
		driver.quit();
	}



	@Epic(" Mobile Tests")
	@Feature("Open  mobile website ")
	@Story("Users should be able to see the mobile version of the  website")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 4, threadPoolSize = 10)
	public void mobileWebTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability("e34:token", "617a27e4-c74c-46");
		caps.setCapability("e34:video", true);
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
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		addVideoLink(driver);
		driver.quit();
	}







	@Epic("Mobile Tests")
	@Feature("Open mobile website ")
	@Story("Users should be able to see the mobile version of the website on multiple devices")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 1, threadPoolSize = 10, dataProvider = "mobileDataProvider", dataProviderClass = TestData.class)
	public void mobileWebTestWithDataProvider(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "mobileWeb  - " + caps.getCapability(MobileCapabilityType.DEVICE_NAME) + " Android " + caps.getCapability(MobileCapabilityType.PLATFORM_VERSION));

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		addVideoLink(driver);
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
			addVideoLink(driver);
			driver.quit();
		}
	}





	@Test(enabled = true, dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 200, threadPoolSize = 200)
	public void loadTest(String url) throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "aa43a67a-0303-4e");
		options.setCapability("e34:l_testName", "load test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 30000));

		driver.quit();
	}

	@Test(enabled = false, dataProvider = "tokenProvider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 220)
	public void userfiltering(ChromeOptions options) throws IOException, InterruptedException {

		options.setCapability("e34:l_testName", "user filtering test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get("http://static.element34.net/e34");
		System.out.println(driver.getTitle());
		Thread.sleep(30000);

		driver.quit();
	}









	private void addVideoLink(RemoteWebDriver driver) {
		io.qameta.allure.model.Link link = new io.qameta.allure.model.Link();
		link.setName("VIDEO URL");
		link.setUrl(HUB + "/videos/" + driver.getSessionId() + ".mp4");
		Allure.addLinks(link);
	}

}
