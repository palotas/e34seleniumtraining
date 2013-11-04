package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {
	

    //constructor
    public WebTests() {
    }

	
	
	@Test
	public void openEbayHomepage() {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//open the ebay homepage
		driver.get("http://www.ebay.com.au");
		
		//close browser
		driver.quit();
	}

	
	@Test
	public void openEbayHomepageAndSignin() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//go to signin URL
		driver.get("https://signin.ebay.com.au/ws/eBayISAPI.dll?SignIn");
		
		//find userid element and type username
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(Utils.getUsername());
		
		//find password element and type password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(Utils.getPassword());
		
		//find signin button and click it
		WebElement signinButton = driver.findElement(By.id("sgnBt"));
		signinButton.click();
	
		
		Thread.sleep(10000);
		//close browser
		driver.quit();
		
	}

	
	@Test
	public void openEbayHomepageAndSigninVerifyPageTitle() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
	
		//go to signin URL
		driver.get("https://signin.ebay.com.au/ws/eBayISAPI.dll?SignIn");
		
		//find userid element and type username
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(Utils.getUsername());
		
		//find password element and type password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(Utils.getPassword());
		
		//find signin button and click it
		WebElement signinButton = driver.findElement(By.id("sgnBt"));
		signinButton.click();
		
		//verify that page title is correct
		Assert.assertEquals(driver.getTitle(), "My eBay Summary");
		
		Thread.sleep(10000);
		
		//close browser
		driver.quit();
	}
	

	@Test
	public void addItemToWatchList() throws InterruptedException {
		//create driver and open browser
		WebDriver driver = new FirefoxDriver();
		
		//go to signin URL
		driver.get("https://signin.ebay.com.au/ws/eBayISAPI.dll?SignIn");
		
		//find userid element and type username
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(Utils.getUsername());
		
		//find password element and type password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(Utils.getPassword());
		
		//find signin button and click it
		WebElement signinButton = driver.findElement(By.id("sgnBt"));
		signinButton.click();
		
		//verify that page title is correct
		Assert.assertEquals(driver.getTitle(), "My eBay Summary");
		
		//search for an item
		//now without defining the WebElement first
		driver.findElement(By.id("gh-ac")).sendKeys("390662314133");
		driver.findElement(By.id("gh-btn")).click();

		
		//add item to watchlist
		driver.findElement(By.id("atl_btn_lnk")).click();
		WebElement msgPad = driver.findElement(By.className("msgPad"));
		Assert.assertTrue(msgPad.getText().contains("Added to your Watch list"));
		
		
		Thread.sleep(10000);
		
		//close browser
		driver.quit();
	}	
	
	
	
	
}
