package webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BasicTests {

	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");

		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}
	
	@Test
	public void firstFirefoxTest() throws FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL
		driver.get("http://www.element34.net");

		// close the Browser
		driver.quit();
	}


	@Test
	public void firstChromeTest() throws FileNotFoundException, IOException {

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
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.element34.net");
		Assert.assertEquals(driver.getTitle(), "Element34 Solutions");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() throws FileNotFoundException, IOException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
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

