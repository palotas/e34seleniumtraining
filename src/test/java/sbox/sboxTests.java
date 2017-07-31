package sbox;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class sboxTests {

	@DataProvider(name = "chromeVersions", parallel = true)
	public Object[][] createData1() {
		return new Object[][] {
				{""},
				{"n-1"},
				{"n-2"},
				{"n-5"}
		};
	}


	@Test(dataProvider = "chromeVersions")
	public void sboxTest(String version) throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		capability.setVersion(version);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), capability);

		System.out.println("Browser version: " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		//System.out.println("Video URL: " + "https://789b1ea7eca7.element34.net/e34/api/video?session=" + driver.getSessionId());
		System.out.println("Video URL: " + "https://vm-106.element34.net/videos/" + driver.getSessionId() + ".mp4");
		Thread.sleep(5000);
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
