package ebayTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ebayPageObjects.EbayUtils;

public class WatchListTests {
	
	@Test
	public void addItemToWatchList() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//go to signin URL
		driver.get("https://signin.ebay.de/ws/eBayISAPI.dll?SignIn");
		
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
		Assert.assertEquals(driver.getTitle(), "Elektronik, Autos, Mode, Sammlerstücke, Gutscheine und mehr Online-Shopping | eBay");
		
		//search for an item
		//now without defining the WebElement first
		driver.findElement(By.id("gh-ac")).sendKeys(EbayUtils.getItemid());
		driver.findElement(By.id("gh-btn")).click();

		
		//add item to watchlist
		driver.findElement(By.className("vi-atw-txt")).click();
		WebElement msgPad = driver.findElement(By.className("msgPad"));
		Assert.assertTrue(msgPad.getText().contains("Hinzugefügt zu Ihrer Beobachtungsliste"));
		
		
		Thread.sleep(5000);
		
		//close browser
		driver.quit();
	}	

}
