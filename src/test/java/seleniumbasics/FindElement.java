package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FindElement {

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
	public void findById() throws FileNotFoundException, InterruptedException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL 
		driver.get("https://www.google.ch");
		WebElement searchField=driver.findElement(By.id("lst-ib"));
		searchField.sendKeys("selenium");
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}

	@Test
	public void findByName() throws InterruptedException, IOException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL 
		driver.get("https://www.google.ch");
		WebElement searchField=driver.findElement(By.name("q"));
		searchField.sendKeys("selenium");
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}

	
	@Test
	public void findByClassName() throws InterruptedException, IOException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL 
		driver.get("https://www.google.ch");
		WebElement searchField=driver.findElement(By.className("gbqfif"));
		searchField.sendKeys("selenium");
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}
	
	
	@Test
	public void findByXpath() throws InterruptedException, IOException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);


		// navigate to the URL�
		driver.get("https://www.google.ch/");
		WebElement searchField=driver.findElement(By.xpath("//*[@id='gbqfq']"));
		searchField.sendKeys("selenium");
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}
	
	
	@Test
	public void findByLinkText() throws InterruptedException, IOException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL 
		driver.get("http://www.20min.ch/");
		WebElement link=driver.findElement(By.linkText("Sport"));
				
		link.click();
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}
	
	
	@Test
	public void findByPartialLinkText() throws InterruptedException, IOException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		// navigate to the URL 
		driver.get("http://www.20min.ch/");
		WebElement link=driver.findElement(By.partialLinkText("Tarif"));
		link.click();
		
		Thread.sleep(5000);
		// close the Browser
		driver.quit();
	}
}
