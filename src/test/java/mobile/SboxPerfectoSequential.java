/*
 * Copyright (c) 2014 - 2019.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package mobile;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class SboxPerfectoSequential {


	private final String perfectoHub = "https://atc.perfectomobile.com/nexperience/perfectomobile/wd/hub";
	private final String sboxHub = "http://vm-106.element34.net/wd/hub";


	@Parameters({"environment", "device"})
	@Test(enabled = true)
	public void runOnSboxAndPerfecto(String environment, String device) throws IOException, InterruptedException {
		RemoteWebDriver driver = buildDriver(environment, device);

		//		driver.get("https://uls-ent.wgrintra.net/schadenwv/servlet/main");
		driver.get("https://axa.ch");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}



	private DesiredCapabilities buildCapabilities(String environment, String device) throws IOException {
		DesiredCapabilities caps = new DesiredCapabilities();

		InputStream inputStream;
		Properties prop = new Properties();
		String propFileName = "perfectoCredentials.properties";
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		switch (environment) {
			case "sbox":
				caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
				caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
				caps.setCapability(CapabilityType.VERSION, "70");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
				caps.setCapability("e34:token", "aa43a67a-0303-4e");
				break;

			case "perfecto":
				caps.setCapability("user", prop.getProperty("username"));
				caps.setCapability("password", prop.getProperty("password"));
				caps.setCapability("deviceName", device); //from testngMobileSequential.xml
	//			caps.setCapability("deviceName", "CE021712B948B4170C"); //Galaxy S8
				caps.setCapability("browserName", "mobileChrome");
				break;
		}
		return caps;
	}

	private RemoteWebDriver buildDriver(String environment, String device) throws IOException {
		RemoteWebDriver driver = null;

		switch (environment) {
			case "sbox":
				driver = new RemoteWebDriver(new URL(sboxHub), buildCapabilities(environment, device));
				break;


			case "perfecto":
				driver = new RemoteWebDriver(new URL(perfectoHub), buildCapabilities(environment, device));
				break;
		}

		return driver;
	}






}