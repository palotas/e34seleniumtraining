/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class GridTests {

	@DataProvider(name = "capabilitiesProvider", parallel=true)
	public Object[][] getCapabilities() {
		return new Object[][] {
				{DesiredCapabilities.firefox()},
				{DesiredCapabilities.chrome()}
		};
	}


	@Test(dataProvider = "capabilitiesProvider")
	public void test1(DesiredCapabilities capability) throws IOException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.axa.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test2(DesiredCapabilities capability) throws IOException, InterruptedException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.google.com");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test3(DesiredCapabilities capability) throws IOException, InterruptedException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.20minuten.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test4(DesiredCapabilities capability) throws IOException, InterruptedException {

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.nzz.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}


}
