/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Helpers.*;
import static sbox.Settings.HUB;

public class SboxDemo {

	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 100)
	public void loadTest(String url) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("e34:l_testName", "Selenium Test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capability);
		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}

}
