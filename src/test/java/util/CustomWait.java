package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class CustomWait {
	
	@Test
	public void customWaitTest() {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver,10); 
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbqfq")));	
		WebElement searchfield=driver.findElement(By.id("gbqfq"));
		searchfield.sendKeys("michael palotas");
		driver.quit();
	}
	
	
	@Test
	public void dropdownFields() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://samples.genexus.com/ajaxsample/client.aspx?INS,0");	
		
		WebElement first=driver.findElement(By.id("CLIENTFIRSTNAME"));
		WebElement last=driver.findElement(By.id("CLIENTLASTNAME"));
		
		WebElement select=driver.findElement(By.id("COUNTRYID"));
		//wrap webelement into Select helper
		Select dropdown=new Select(select); 
		//System.out.println("selected option: " + dropdown.getFirstSelectedOption().getText());
		
		first.sendKeys("michael");
		last.sendKeys("müller");
		dropdown.selectByValue("405"); //value for "Uruguay"
		//dropdown.selectByVisibleText("Brazil");
		
		//check if proper cities are are populated in the city field
		//first set up the expected data
		ArrayList<String>expectedCities=new ArrayList<String>();
		expectedCities.add("Canelones");
		expectedCities.add("Maldonado");
		expectedCities.add("Montevideo");
		expectedCities.add("Paysandú");
		expectedCities.add("Piriápolis");
		expectedCities.add("Salto");
		expectedCities.add("sauce");
		expectedCities.add("Soriano");
		
		Select citydropdown=new Select(driver.findElement(By.id("CITYID"))); 
		ArrayList<String> options = new ArrayList<String>();

		for(WebElement element : citydropdown.getOptions()) {
			//System.out.println(element.getText());
			options.add(element.getText());
		}
		for(String s : options) {
			System.out.println(s);
		}
		//check if populated city list is as expected
		Assert.assertTrue(options.equals(expectedCities));
			
		Thread.sleep(5000);
		driver.quit();		
	}
	
	
	@Test
	public void tabSelectTest() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://samples.genexus.com/ajaxsample/viewinvoice.aspx?586,");
		Thread.sleep(2000);
		
		WebElement invoiceTab=driver.findElement(By.xpath("//*[@id='LineTab']/span/span/span"));
		invoiceTab.click();
		
		
		Thread.sleep(3000);
		
	}
	
	@Test
	public void hoverTest() throws Exception {
		
		//native events do not work properly in Firefox
		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.get("http://www.xing.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("login_form[username]"))));			
		
		/*
		//check if username is present
		if(isElementPresent(driver, By.name("login_form[username]")))
			System.out.println("username field is present");
		else
			System.out.println("username field is NOT present");
		*/	
		
		WebElement username=driver.findElement(By.name("login_form[username]"));
		WebElement password=driver.findElement(By.name("login_form[password]"));
		WebElement button=driver.findElement(By.className("button-gray"));
		
		username.sendKeys("michael.palotas@gridfusion.net");
		password.sendKeys("michael1122");
		button.click();
		
		//Thread.sleep(5000);
		
		Actions action=new Actions(driver);
		
		//WebElement link=driver.findElement(By.linkText("Jobs")); OR USE BELOW
		WebElement link=isElementClickable(driver, By.linkText("Jobs")); //OR USE BELOW
		
		

		
		
		action.moveToElement(link).build().perform();
		//action.moveToElement(link).moveToElement(driver.findElement(By.linkText("Stellenanzeigen verwalten"))).build().perform();
		
		//check which links are opening up
		WebElement navMain=driver.findElement(By.id("nav-main"));
		List<WebElement> aList=navMain.findElements(By.cssSelector("a"));
		System.out.println("size of li: " + aList.size());
		
		List<String> stringList =new ArrayList<String>();
		
		for(WebElement we : aList) {
			System.out.println(we.getText());
			//dump linktexts into a list of Strings
			stringList.add(we.getText());
		}
		
		
		for(String s : ExpectedData.expectedLinks) {
			Assert.assertTrue(stringList.contains(s));			
		}
				
		util.Screenshot.takeScreenshot2(driver); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		driver.quit();
		
	}
	
	
	
	public boolean isElementPresent(WebDriver driver, By by) {
		
		  try {
		        driver.findElement(by);
		        return true;
		     } catch (NoSuchElementException e) {
		         return false;
		    }
		}


	public WebElement isElementClickable(final WebDriver driver, final By by) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return ExpectedConditions.elementToBeClickable(by).apply(driver);
			}
		});
	}
	
	
	public static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
	            .pollingEvery(500, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);

	    return wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver webDriver) {
	            return driver.findElement(locator);
	        }
	    });
	}
	
	
	public void mytest(WebDriver driver) {
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);
		 
		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });
		   //and now work with foo element
	}
	
}
