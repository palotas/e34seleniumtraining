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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SboxPerfectoParallel {


	private final String perfectoHub = "https://atc.perfectomobile.com/nexperience/perfectomobile/wd/hub";
	private final String sboxHub = "http://vm-106.element34.net/wd/hub";


	@DataProvider(name = "devices", parallel = true)
	public Object[][] getParameters() {
		return new Object[][] {
				{"sbox", "Galaxy S8"},
				{"sbox", "Galaxy S9"},
				{"perfecto", "AD061703BC98E5024B"}, //S7
				//{"perfecto", "CE021712B948B4170C"}, //S8
				{"perfecto", "2B92E5C711027ECE"} //S9
		};
	}

	@Test(dataProvider = "devices")
	public void runOnSboxAndPerfectoParallel(String environment, String device) throws IOException, InterruptedException {
		RemoteWebDriver driver = buildDriver(environment, device);

		//		driver.get("https://uls-ent.wgrintra.net/schadenwv/servlet/main");
		driver.get("https://axa.ch");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}



	private DesiredCapabilities buildCapabilities(String environment, String device) {
		DesiredCapabilities caps = new DesiredCapabilities();

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
				caps.setCapability("user", "dario.lorenzon@axa-winterthur.ch");
				caps.setCapability("password", "SeleniumMobile!2019");
				caps.setCapability("deviceName", device);
				caps.setCapability("browserName", "mobileChrome");
				break;
		}
		return caps;
	}

	private RemoteWebDriver buildDriver(String environment, String device) throws MalformedURLException {
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
