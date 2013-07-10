package seleniumTests;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class GridTests {


	@Test
	public void firefox1() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://gridfusion.net");

		Thread.sleep(2000);

		driver.quit();
	}
	

	@Test
	public void firefox2() throws IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.abraxas.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void chrome1() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://gridfusion.net");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void chrome2() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://gridfusion.net");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void chrome3() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.abraxas.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}


}
