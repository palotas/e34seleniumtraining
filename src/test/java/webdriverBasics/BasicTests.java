package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests {

	@Test
	public void firstFirefoxTest() throws FileNotFoundException, IOException {
                
        WebDriver driver = util.AxaDriverFactory.createAxaFirefoxDriver();
		
		// navigate to the URL
		driver.get("http://gridfusion.net");

		// close the Browser
		driver.quit();
	}
	

	@Test
	public void firstLocalIETest() throws FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		
		// navigate to the URL 
		driver.get("http://gridfusion.net");
		// close the Browser
		driver.quit();
}


	@Test
	public void pageTitleTest() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	@Test
	public void pageTitleTestWithAssertNoTryCatch() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		driver.get("http://gridfusion.net");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSION");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		try {
			driver.get("http://gridfusion.net");
			Assert.assertEquals(driver.getTitle(), "ridfusion");			
		}
		finally {
			driver.quit();			
		}
	}
	
}

