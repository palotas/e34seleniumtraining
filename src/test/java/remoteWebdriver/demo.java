/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class demo {

	//https://aut.element34.net:8443/spnego/debug

	@Test()
	public void demoChrome() throws IOException, InterruptedException {

		String loopsString = "";
		int loops = 0;
		loopsString = System.getenv("loops");
		loops = Integer.valueOf(loopsString);

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("e34:token", "214a2db6-0a65-47");
		caps.setCapability("e34:l_testName",  "Checkout " + caps.getBrowserName());

		WebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), caps);



		for (int i = 0; i<loops; i++) {
			driver.get("http://static.element34.net");
			Thread.sleep(2000);
		}

		driver.quit();
	}
}
