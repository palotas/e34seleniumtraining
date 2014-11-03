package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SendKeys {
	
	/*
	 * This test: - creates Firefox Driver / opens a Firefox browser - navigates
	 * to http://www.abraxas.ch - locates element with ID "searchField" - types
	 * "Java" into the searchbox - locates submit button - clicks on the
	 * submit button - closes the browser
	 */

	@Test
	public void sendKeysTest() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.abraxas.ch");

		WebElement searchBox = driver.findElement(By.id("searchField"));
		searchBox.sendKeys("Java");

		WebElement button = driver.findElement(By.className("searchButton"));
		button.click();
		
		Thread.sleep(5000);

		driver.quit();

	}

	
	/*
	 * This test: opens a CHROME browser - navigates
	 * to http://www.abraxas.ch - locates element with ID "searchField" - types
	 * "Java" into the searchbox - locates submit button - clicks on the
	 * submit button - closes the browser
	 */
	@Test
	public void sendKeysTestWithChrome() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.abraxas.ch");

		WebElement searchBox = driver.findElement(By.id("searchField"));

		searchBox.sendKeys("Java");

		WebElement button = driver.findElement(By.className("searchButton"));
		button.click();
		
		Thread.sleep(5000);

		driver.quit();

	}
}
