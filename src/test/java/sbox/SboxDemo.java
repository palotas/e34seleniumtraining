/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Settings.HUB;

public class SboxDemo {


	@Test
	public void mobile() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability(CapabilityType.VERSION, "67");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X GPS");

		caps.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		caps.setCapability("e34:video" , true);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.quit();
	}


	@Test
	public void demoSbox() throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		options.setCapability("e34:video" , true);
		options.setCapability("e34:l_testName", "sbox demo test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();


		for (int i= 0; i < 2; i++) {
			driver.get("https://element34.com");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Consulting")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Training")).click();

		}
		driver.quit();
	}



	@Test(invocationCount = 30)
	public void demo() throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		//options.setCapability("e34:token" , "3cff2a64-14ba-43"); //austin / adoring edison
		options.setCapability("e34:video" , true);
		options.setCapability("e34:l_testName", "bmw with wait");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
//		Thread.sleep(1000);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		System.out.println(driver.getSessionId());


		for (int i= 0; i < 2; i++) {
//			driver.get("http://static.element34.net/e34");
//			driver.getTitle();
//			driver.get("http://static.element34.net/the-internet");
//			driver.getTitle();


			driver.get("http://www.bmw-brilliance.cn/cn/en/index.html");
			Thread.sleep(2000);
 			driver.findElement(By.linkText("Company Information")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Careers")).click();

		}


		wait.until(ExpectedConditions.titleIs("BMW Brilliance：Working in BMW Brilliance"));
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.bmw-brilliance.cn/cn/en/hr/index.html" );
		Thread.sleep(5000);
		driver.quit();
	}



	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class, invocationCount = 50)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("video", true);
		caps.setCapability("e34:token" , "19705d15-03b8-4f");
		caps.setCapability("e34_per_test_timeout_ms", 300000);
		caps.setCapability("e34:l_testName", caps.getBrowserName() + "  " + caps.getVersion());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);

		for (int i=0; i<5; i++) {
			driver.get("https://element34.com");
			Thread.sleep(2000);
			driver.get("https://google.com");
			Thread.sleep(2500);
		}
		driver.quit();
	}

	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 40, threadPoolSize = 120)
	public void loadTest(String url) throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f");
		options.setCapability("e34:l_testName", "load test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}

}
