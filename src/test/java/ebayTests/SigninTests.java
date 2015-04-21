package ebayTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ebayPageObjects.EbayUtils;

public class SigninTests {
	
	@Test
	public void openEbayHomepage() throws FileNotFoundException, IOException {
		//create driver and open browser
		WebDriver driver = util.AxaDriverFactory.createAxaFirefoxDriver();
		
		//open the ebay homepage
		driver.get("http://www.ebay.ch");
		
		//close browser
		driver.quit();
	}

	@Test
	public void openEbayHomepageAndSignin() throws InterruptedException, FileNotFoundException, IOException {
		//create driver and open browser
		WebDriver driver = util.AxaDriverFactory.createAxaFirefoxDriver();
		
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
	public void openEbayHomepageAndSigninVerifyPageTitle() throws InterruptedException, FileNotFoundException, IOException {
		//create driver and open browser
		WebDriver driver = util.AxaDriverFactory.createAxaFirefoxDriver();
		
	
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
