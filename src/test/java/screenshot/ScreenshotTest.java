package screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ScreenshotTest {
	
	@Test
	public void testWithScreenshot() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		Screenshot.takeScreenshotNoReport(driver);
		driver.quit();
	}
	
	
	@Test
	public void testWithScreenshotAndReport() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		Screenshot.takeScreenshotWithReport(driver);
		driver.quit();
	}
	
}
