package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FindElement {


	@Test
	public void findById() throws FileNotFoundException, InterruptedException {

		// create the driver and open Firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
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
		capabilities.setCapability("marionette", false);
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
		capabilities.setCapability("marionette", false);
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
		capabilities.setCapability("marionette", false);
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
		capabilities.setCapability("marionette", false);
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
		capabilities.setCapability("marionette", false);
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
