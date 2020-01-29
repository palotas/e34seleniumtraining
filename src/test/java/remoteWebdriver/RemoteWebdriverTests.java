/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class RemoteWebdriverTests {

	@DataProvider(name = "capsProvider", parallel = true)
	public Object[][] caps() {
		return new Object[][] {
				{DesiredCapabilities.chrome()},
				//{DesiredCapabilities.firefox()},
				//{DesiredCapabilities.internetExplorer()},
				//{DesiredCapabilities.edge()}
		};
	}


	@Test(dataProvider = "capsProvider", invocationCount = 1, threadPoolSize = 5)
	public void remoteWebdriverChromeTest(DesiredCapabilities caps) throws IOException, InterruptedException {

		caps.setCapability("e34:token", "c24c543b-9059-40");
		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "BT Demo Test");
		WebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), caps);

		driver.get("https://bt.com");
		Assert.assertEquals(driver.getTitle(), "Fibre Broadband, TV Packages, BT Sport & Mobile Deals | BT");

		Thread.sleep(5000);
		driver.get("https://google.com");
		Thread.sleep(5000);


		driver.quit();
	}

}
