/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class RemoteWebdriverTests {

	@Test
	public void remoteWebdriverChromeTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	public void chromeOptions() throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
