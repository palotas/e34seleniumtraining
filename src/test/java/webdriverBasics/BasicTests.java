package webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BasicTests {
	
	@Test
	public void firstFirefoxTest() throws FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL
		driver.get("http://www.element34.net");

		// close the Browser
		driver.quit();
	}


	@Test
	public void firstChromeTest() throws FileNotFoundException, IOException {

		System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(capabilities);

		// navigate to the URL
		driver.get("http://www.element34.net");

		// close the Browser
		driver.quit();
	}

	@Test
	public void pageTitleTest() throws InterruptedException, FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.element34.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	@Test
	public void pageTitleTestWithAssertNoTryCatch() throws FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.element34.net");
		Assert.assertEquals(driver.getTitle(), "Element34 Solutions");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() throws FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);

		try {
			driver.get("http://www.element34.net");
			Assert.assertEquals(driver.getTitle(), "Element34 Solut");
		}
		finally {
			driver.quit();			
		}
	}
	
}

