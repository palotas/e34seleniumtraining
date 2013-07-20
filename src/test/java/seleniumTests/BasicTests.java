package seleniumTests;

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
	public void pageTitleTest() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
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
		driver.get("http://gridfusion.net");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");
		driver.quit();
	}
	
	
	/*
	 * in the above example upon assertion failure the test stops
	 * and the browser is not closed
	 * this can be avoided by putting adding a try/catch/finally block
	 */
	@Test
	public void pageTitleTestWithException() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get("http://www.abraxas.ch");
			Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");	
		}
		catch (Error e) {
			System.out.println("Error message: " + e.getMessage());
			/*
			 * note: the test passes because we caught the exception
			 * to make it fail add: Assert.fail();
			 */
		}
		finally {
			driver.quit();
		}

	}

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
