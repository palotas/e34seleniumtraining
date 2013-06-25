package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
			driver.get("http://digicomp.ch");
			Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");	
		}
		catch (Exception e) {
			System.out.println("Exception message: " + e.getMessage());
		}
		finally {
			driver.quit();
		}

	}

	/*
	 * This test: - creates Firefox Driver / opens a Firefox browser - navigates
	 * to http://www.digicomp.ch - locates element with ID "q" - types
	 * "Selenium" into the searchbox - locates submit button - clicks on the
	 * submit button - closes the browser
	 */

	@Test
	public void sendKeysTest() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.digicomp.ch");

		WebElement searchBox = driver.findElement(By.id("q"));
		searchBox.sendKeys("Selenium");

		WebElement button = driver.findElement(By.className("submitsearch"));
		button.click();

		driver.quit();

	}


	/*
	 * This test: - creates FIREFOX Driver / opens a FIREFOX browser - navigates
	 * to http://www.digicomp.ch - locates element with ID "q" - types
	 * "Selenium" into the searchbox - locates submit button - clicks on the
	 * submit button$ - locate DOM node "result" - locate td with result set via
	 * xpath - get text in td - extract substring from text - assert that it
	 * says "1-1" meaning that there is only one course - closes the browser
	 */
	@Test
	public void onlyOneSeleniumTest() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.digicomp.ch");

		WebElement searchBox = driver.findElement(By.id("q"));
		searchBox.sendKeys("Selenium");

		WebElement button = driver.findElement(By.className("submitsearch"));
		button.click();


		// access the desired text via xpath
		WebElement td = driver.findElement(By.xpath("//table[@id='result']/tbody/tr[2]/td"));
		String text = td.getText();
		System.out.println(text);
		
		String substring = text.substring(11, 16);
		Assert.assertEquals(substring, "1 - 1");

		driver.quit();

	}

	/*
	 * This test: - creates CHROME Driver / opens a CHROME browser - navigates
	 * to http://www.digicomp.ch - locates element with ID "q" - types
	 * "Selenium" into the searchbox - locates submit button - clicks on the
	 * submit button - closes the browser
	 */
	@Test
	public void sendKeysTestWithChrome() {

		System.setProperty("webdriver.chrome.driver",
				"/home/gridfusion/SeleniumTraining/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.digicomp.ch");

		WebElement searchBox = driver.findElement(By.id("q"));

		searchBox.sendKeys("Selenium");

		WebElement button = driver.findElement(By.className("submitsearch"));
		button.click();

		driver.quit();

	}

}
