package sbox;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;


public class sboxTests {

	@Test
	public void sboxTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		capability.setVersion("n-2");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), capability);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:4444/wd/hub"), capability);

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		//System.out.println("Video URL: " + "https://789b1ea7eca7.element34.net/e34/api/video?session=" + driver.getSessionId());
		//System.out.println("Video URL: " + "http://vm-105.element34.net:8080/videos/" + driver.getSessionId() + ".mp4");
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
