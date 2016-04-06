package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests {
	
	@Test
	public void firstFirefoxTest() throws FileNotFoundException, IOException {
                
		WebDriver driver = new FirefoxDriver();
		
		// navigate to the URL
		driver.get("http://gridfusion.net");

		// close the Browser
		driver.quit();
	}
	


	@Test
	public void pageTitleTest() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	@Test
	public void pageTitleTestWithAssertNoTryCatch() throws FileNotFoundException, IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSIONhds");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() throws FileNotFoundException, IOException {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get("http://gridfusion.net");
			Assert.assertEquals(driver.getTitle(), "ridfusion");			
		}
		finally {
			driver.quit();			
		}
	}
	
}

