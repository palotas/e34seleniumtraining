/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Settings.HUB;

public class CbaDemo {

	@Test
	public void demoSbox() throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f");
		options.setCapability("video" , true);
		options.setCapability("e34:l_testName", "CBA demo test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();


		for (int i= 0; i < 3; i++) {
			driver.get("https://www.commbank.com.au");
			Thread.sleep(2000);
			driver.findElement(By.className("log-on-text")).click();
			Thread.sleep(2000);
			WebElement iFrame = driver.findElement(By.className("netbank-login"));
			driver.switchTo().frame(iFrame);
			driver.findElement(By.id("txtMyClientNumber_field")).sendKeys("123456");
			Thread.sleep(2000);
			driver.findElement(By.id("txtMyPassword_field")).sendKeys("12345");
			Thread.sleep(2000);
		}

		driver.quit();
	}


	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 20)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("video", true);
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		caps.setCapability("e34:l_testName", "CBA - " + caps.getBrowserName() + "  " + caps.getVersion());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.manage().window().maximize();


		for (int i= 0; i < 5; i++) {
			driver.get("https://www.commbank.com.au");
			Thread.sleep(2000);
			driver.findElement(By.className("log-on-text")).click();
			Thread.sleep(2000);
			WebElement iFrame = driver.findElement(By.className("netbank-login"));
			driver.switchTo().frame(iFrame);
			driver.findElement(By.id("txtMyClientNumber_field")).sendKeys("123456");
			Thread.sleep(2000);
			driver.findElement(By.id("txtMyPassword_field")).sendKeys("12345");
			Thread.sleep(12000);

		}
		driver.quit();
	}



	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 70, threadPoolSize =100)
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
