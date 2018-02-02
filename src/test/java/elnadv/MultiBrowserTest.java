/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static elnadv.Helpers.sleepTight;
import static sbox.Settings.HUB;

public class MultiBrowserTest extends BaseTest {


	@DataProvider(name = "chromeVersions", parallel = true)
	public Object[][] createVersions1() {
		return new Object[][] {
				{"64"},
				{"63"},
				{"62"},
				{"61"},
				{"60"}
		};
	}

	@Test(dataProvider = "chromeVersions")
	public void multiChromeTest(String version) throws IOException {

		//set HUB Url and port to where your endpoint is
		String HUB = "http://localhost:4444";

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setVersion(version);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		driver.manage().window().fullscreen();
		driver.get("https://www.infometis.ch");
		System.out.println("Video URL: " + HUB + "/videos/" + driver.getSessionId() + ".mp4");
		driver.quit();

	}

}
