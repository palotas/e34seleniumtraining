package seleniumTests;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Navigation {
	
	/*
	 * This test:
	 * - opens a Firefox browser and navigates to http://gridfusion.net
	 * - clicks on Link "Services"
	 * - navigate back to previous page and assert that page title is correct
	 * - navigate forward to Services page and assert that page title is correct
	 * - close browser
	 */
	@Test
	public void navigate() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net/");
		
		WebElement link = driver.findElement(By.linkText("SERVICES"));
		link.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Assert.assertEquals("GRIDFUSION.net - Home", driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().forward();
		Assert.assertEquals("GRIDFUSION.net - Services", driver.getTitle());
		Thread.sleep(3000);
		driver.quit();		
	}
	


}
