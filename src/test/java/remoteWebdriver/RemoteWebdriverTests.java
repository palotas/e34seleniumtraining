/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class RemoteWebdriverTests {

	//@BeforeTest
	//public void setup() {
	//	Settings.setHubUrl("https://vm-106.element34.net");
	//}

	@Test
	public void remoteWebdriverChromeTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

/*	@WebTest(video = true, browsers = Browsers.TIER1)
	@Test
	public void sboxTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();

		webdriver().get("http://www.google.com");
		System.out.println(webdriver().getTitle());
		webdriver().quit();
	}*/
}
