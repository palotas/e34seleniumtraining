/*
 * Copyright (c) 2014 - 2019.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


@Test(invocationCount = 1, threadPoolSize = 100)
public class BrowserWithOptions {

	final String sboxUrl = "https://vm-105.element34.net/wd/hub";


	@Test(invocationCount = 1, threadPoolSize = 100)
	public void hebrew() throws MalformedURLException, InterruptedException {

		String sboxUrl = "https://vm-105.element34.net/wd/hub";

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, "77"); //if left empty, the most recent browser version is used on SBOX
		options.setCapability("e34:l_testName", "Testim mobile emulation Chrome");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:token", "baddd26e-690f-4d");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("\u05E6");
		//driver.get("https://testim.io");
		Thread.sleep(5000);

		driver.quit();
	}



	@Test(invocationCount = 1, threadPoolSize = 100)
	public void chrome() throws MalformedURLException, InterruptedException {

		String sboxUrl = "https://vm-105.element34.net/wd/hub";

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, "77"); //if left empty, the most recent browser version is used on SBOX
		options.setCapability("e34:l_testName", "Testim mobile emulation Chrome");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:token", "baddd26e-690f-4d");

		options.addArguments("--window-size=375,812");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
		driver.get("https://www.gov.il/he/");
		//driver.get("https://testim.io");
		Thread.sleep(5000);

		driver.quit();
	}


	public void firefox() throws MalformedURLException, InterruptedException {

		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, "70"); //if left empty, the most recent browser version is used on SBOX
		options.setCapability("e34:l_testName", "Testim integration test with Firefox");
		options.setCapability("e34:video", true); //boolean not String !!
		options.setCapability("e34:token", "baddd26e-690f-4d");


		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
		driver.get("https://testim.io");
		Thread.sleep(5000);
		driver.quit();
	}


	@Test
	public void withIEOptions() throws MalformedURLException, InterruptedException {

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("e34:l_testName", "Testim integration test with IE");
		options.setCapability("e34:video", true); //boolean not String !!
		options.setCapability("e34:token", "baddd26e-690f-4d");


		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
		driver.get("https://testim.io");
		Thread.sleep(5000);
		driver.quit();
	}

	public void withEdgeOptions() throws MalformedURLException, InterruptedException {

		EdgeOptions options = new EdgeOptions();

		options.setCapability("e34:l_testName", "Testim integration test with MS Edge");
		options.setCapability("e34:video", true); //boolean not String !!
		options.setCapability("e34:token", "baddd26e-690f-4d");


		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
		driver.get("https://testim.io");
		Thread.sleep(5000);
		driver.quit();
	}

}
