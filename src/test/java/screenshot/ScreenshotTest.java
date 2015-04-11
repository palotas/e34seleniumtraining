package screenshot;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {
	
	@Test
	public void testWithScreenshot() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		DoScreenshot.takeScreenshotNoReport(driver);
		driver.quit();
	}


	@Test
	public void testWithScreenshotAndReportRemote() throws Exception {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		
		driver.get("http://gridfusion.net");
		DoScreenshot.remoteWebDriverScreenshot(driver);
		driver.quit();
	}
}
