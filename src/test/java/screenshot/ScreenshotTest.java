package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void testWithScreenshotAndReport() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		DoScreenshot.takeScreenshotWithReport(driver);
		driver.quit();
	}
	
}
