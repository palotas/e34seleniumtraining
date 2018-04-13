/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class SboxDemo {

	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 10, threadPoolSize = 100)
	public void loadTest(String url) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("e34:l_testName", "Selenium Test");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}

	@Test(invocationCount = 1, threadPoolSize = 5)
	public void demo() throws IOException, InterruptedException {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
//		capability.setCapability("e34:token" , "ff03bc41-1662-44");//secretguy
		//capability.setCapability("e34:token" , "693c4d9d-e3dc-41"); //mpalotas, Angular4
//		capability.setCapability("e34:token" , "0aea6291-ccd7-4a"); //mpalotas, HP redesign
		capability.setCapability("e34:token" , "ff03bc41-1662-44"); //secretguy, secret project
		capability.setCapability("e34:video" , true);
//		capability.setCapability("e34:l_testName" , "Angular4 test with a super long tets name");
//		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		driver.manage().window().maximize();

		for (int i=0; i<2; i++) {
//			driver.get("http://static.element34.net/e34");
			driver.get("https://www.google.com");
			driver.findElement(By.id("lst-ib")).sendKeys("hello world");
			Thread.sleep(1000);


			driver.get("http://static.element34.net/the-internet");
			driver.getTitle();
			Thread.sleep(1000);
		}

		driver.quit();
	}

}
