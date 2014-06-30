package ebayTests;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import ebayPageObjects.EbayUtils;

public class SigninTests {
	
	@Test
	public void openEbayHomepage() {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//open the ebay homepage
		driver.get("http://www.ebay.ch");
		
		//close browser
		driver.quit();
	}

	@Test
	public void openEbayHomepageAndSignin() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//go to signin URL
		driver.get("https://signin.ebay.ch/ws/eBayISAPI.dll?SignIn");
		
		//find userid element and type username
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(EbayUtils.getUsername());
		
		//find password element and type password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(EbayUtils.getPassword());
		
		//find signin button and click it
		WebElement signinButton = driver.findElement(By.id("sgnBt"));
		signinButton.click();
	
		Thread.sleep(5000);
		//close browser
		driver.quit();
		
	}
	
	
	@Test
	public void openEbayHomepageAndSigninVerifyPageTitle() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
	
		//go to signin URL
		driver.get("https://signin.ebay.ch/ws/eBayISAPI.dll?SignIn");
		
		//find userid element and type username
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(EbayUtils.getUsername());
		
		//find password element and type password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(EbayUtils.getPassword());
		
		//find signin button and click it
		WebElement signinButton = driver.findElement(By.id("sgnBt"));
		signinButton.click();
		
		//verify that page title is correct
		Assert.assertEquals("Elektronik, Autos, Mode, Sammlerstücke, Gutscheine und mehr Online-Shopping | eBay", driver.getTitle());
		
		Thread.sleep(5000);
		
		//close browser
		driver.quit();
	}
	
	
}
