package sbox;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class sboxTests {

	//runs Chrome in version LATEST and LATEST-x
	@DataProvider(name = "chromeVersions", parallel = true)
	public Object[][] createData1() {
		return new Object[][] {
				{""},
				{"n-1"},
				{"n-2"},
				{"n-5"}
		};
	}

	//browsers and versions are hardcoded on the data provider
	@DataProvider(name = "browserProvider", parallel = true)
	public Object[][] getDrivers() {
		DesiredCapabilities firefox1 = DesiredCapabilities.firefox();
		firefox1.setCapability("version", "52");

		DesiredCapabilities firefox2 = DesiredCapabilities.firefox();
		firefox2.setCapability("version", "51");

		DesiredCapabilities firefox3 = DesiredCapabilities.firefox();
		firefox3.setCapability("version", "50");

		DesiredCapabilities chrome1 = DesiredCapabilities.chrome();
		chrome1.setCapability("version", "58");

		DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
		chrome2.setCapability("version", "57");

		DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
		chrome3.setCapability("version", "56");

		return new Object[][]{
				{firefox1},
				{firefox2},
				{firefox3},
				{chrome1},
				{chrome2},
				{chrome3},
    };
	}


	//no hardcoded versions. Sliding window depending on what is configured on SBOX as LATEST
	@DataProvider(name = "browserProviderWithoutVersions", parallel = true)
	public Object[][] getDriversWithoutVersion() {

		//if no version is set, then latest browser version is used
		DesiredCapabilities firefox1 = DesiredCapabilities.firefox();

		//use n-1, n-1 etc. to specify non-hardcoded browserversions (sliding window)
		DesiredCapabilities firefox2 = DesiredCapabilities.firefox();
		firefox1.setCapability("version", "n-1");

		DesiredCapabilities firefox3 = DesiredCapabilities.firefox();
		firefox1.setCapability("version", "n-2");

		DesiredCapabilities chrome1 = DesiredCapabilities.chrome();

		DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
		chrome2.setCapability("version", "n-1");

		DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
		chrome3.setCapability("version", "n-2");

		return new Object[][]{
				{firefox1},
				{firefox2},
				{firefox3},
				{chrome1},
				{chrome2},
				{chrome3},
		};
	}



	@Test(dataProvider = "chromeVersions")
	public void sboxTest(String version) throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		capability.setVersion(version);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), capability);

		System.out.println("Browser version: " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());
		driver.get("http://www.google.com");
		System.out.println("Video URL: " + "https://vm-106.element34.net/videos/" + driver.getSessionId() + ".mp4");
		Thread.sleep(5000);
		driver.quit();
	}

	@Test(dataProvider = "browserProvider")
	public void multiBrowser(DesiredCapabilities caps) throws IOException, InterruptedException {

		caps.setCapability("video", true);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), caps);

		//add company specific URL here
		driver.get("http://www.google.com");
		System.out.println("Video URL - " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion() + " : " + "https://vm-106.element34.net/videos/" + driver.getSessionId() + ".mp4");
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void fileDownload() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("firefox");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), capability);

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		System.out.println("Session ID: " + driver.getSessionId());
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
