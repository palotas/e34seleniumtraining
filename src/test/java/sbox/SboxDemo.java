/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Settings.HUB;

public class SboxDemo {


	@Test
	public void demo() throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		options.setCapability("e34:video" , true);
		options.setCapability("e34:l_testName", "t-mobile demo test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		//driver.manage().window().maximize();


		for (int i= 0; i < 5; i++) {
			driver.get("https://t-mobile.com");
			Thread.sleep(2000);
			driver.get("https://google.com");
			Thread.sleep(2000);
		}
		driver.quit();
	}



	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("video", true);
		caps.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		caps.setCapability("e34_per_test_timeout_ms", 300000);
		caps.setCapability("e34:l_testName", caps.getBrowserName() + "  " + caps.getVersion());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);

		driver.get("https://t-mobile.com");
		Thread.sleep(10000);

		driver.quit();
	}

	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 50, threadPoolSize = 150)
	public void loadTest(String url) throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		options.setCapability("e34:l_testName", "load test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}

}
