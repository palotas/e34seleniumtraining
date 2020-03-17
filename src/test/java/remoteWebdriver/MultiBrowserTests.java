/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class MultiBrowserTests {

	int LOOPS = 5;

	@DataProvider(name = "capsProvider", parallel = true)
	public Object[][] caps() {
		return new Object[][] {
				{DesiredCapabilities.chrome(), "79"},
//				{DesiredCapabilities.chrome(), "78"},
//				{DesiredCapabilities.chrome(), "77"},
//				{DesiredCapabilities.firefox(), ""},
//				{DesiredCapabilities.internetExplorer(), ""},
//				{DesiredCapabilities.edge(), ""}
		};
	}


	@Test(dataProvider = "capsProvider", invocationCount = 1, threadPoolSize = 5)
	public void remoteWebdriverChromeTest(DesiredCapabilities caps, String version) throws IOException, InterruptedException {

		caps.setCapability("e34:token", "c24c543b-9059-40");
		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "Scriptworks Demo Test: " + caps.getBrowserName() + " " + version);

		caps.setVersion(version);

		WebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), caps);

		for (int i=0; i<LOOPS; i++) {
			driver.get("https://scriptworks.io");
			Assert.assertEquals(driver.getTitle(), "Home Page | Scriptworks");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#menu-item-1639 > a")).click();

			Thread.sleep(2000);

			driver.findElement(By.name("first-name")).sendKeys("Michael");

			Thread.sleep(2000);

			driver.findElement(By.name("last-name")).sendKeys("Palotas");

			Thread.sleep(5000);
		}


		driver.quit();
	}

}
