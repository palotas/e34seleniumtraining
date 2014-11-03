package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests {

	/*
	 * This test: - creates a new Firefox Driver / open a Firefox Browser -
	 * opens the page http://gridfusion.net - closes the browser
	 * 
	 * Please note: no actual verification of anything is done
	 * 
	 * If you install from scratch: make sure to put selenium jar into classpath
	 * test runs with local firefox driver selenium server jar does not need to
	 * run for this
	 */
	@Test
	public void myFirstTest() {

		// create the driver and open Firefox
		WebDriver driver = new FirefoxDriver();

		// navigate to the URL 
		driver.get("http://gridfusion.net");

		// close the Browser
		driver.quit();
	}

	/*
	 * This test: - creates Firefox Driver / opens a Firefox browser - navigates
	 * to http://gridfusion.net - gets the page title - prints out the page
	 * title - closes the browser - note: test will always pass, as no asserts
	 * are done
	 */
	@Test
	public void pageTitleTest() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}

	/*
	 * This test: - creates Firefox Driver / opens a Firefox browser - navigates
	 * to http://gridfusion.net - assert that page title is
	 * "GRIDFUSION.net - Home" - closes the browser
	 */
	@Test
	public void pageTitleTestWithAssert() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get("http://gridfusion.net");
			Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");			
		}
		finally {
			driver.quit();			
		}

		
	}
}