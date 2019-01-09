/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Settings.HUB;

public class MastercardDemo {

	private RemoteWebDriver setupSingleTest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f");
		options.setCapability("video" , true);
		options.setCapability("e34:l_testName", "Mastercard demo test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		return driver;
	}

	@Test
	public void demoSbox() throws IOException, InterruptedException {

		RemoteWebDriver driver = setupSingleTest();

		for (int i= 0; i < 3; i++) {
			driver.get("https://www.mastercard.us/en-us.html#");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Consumers")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Find A Card"));
			Thread.sleep(2000);
			driver.findElement(By.id("search-open")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("query")).sendKeys("Mastercard Gold");
			Thread.sleep(2000);
			driver.findElement(By.className("search-btn")).click();
			Thread.sleep(2000);
		}

		driver.quit();
	}


	private RemoteWebDriver setupMultibrowserTest(DesiredCapabilities capabilities) throws MalformedURLException {
		DesiredCapabilities caps = capabilities;
		caps.setCapability("video", true);
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		caps.setCapability("e34:l_testName", "Mastercard - " + caps.getBrowserName() + "  " + caps.getVersion());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.manage().window().maximize();
		return driver;
	}




	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		RemoteWebDriver driver = setupMultibrowserTest(caps);

		for (int i= 0; i < 10; i++) {
			driver.get("https://www.mastercard.us/en-us.html#");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Consumers")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Find A Card"));
			Thread.sleep(2000);
			driver.findElement(By.id("search-open")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("query")).sendKeys("Mastercard Gold");
			Thread.sleep(5000);
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
