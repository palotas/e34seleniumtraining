package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import util.ExpectedData;

public class WebDriverActions {
	
	@Test
	public void navigateGwtMenu() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwMenuBar");

		WebElement fileMenu=driver.findElement(By.id("gwt-debug-cwMenuBar-item0"));
		fileMenu.click();
		Thread.sleep(2000);
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.id("gwt-debug-cwMenuBar-item0-item4"))).click().build().perform();
	    
	    Thread.sleep(2000);
	    driver.quit();

	}
	
	
	
	
	@Test
	public void xingHoverTest() throws Exception {
		
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
		
		//enter your username / password here
		username.sendKeys("");
		password.sendKeys("");
		button.click();
		
		
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
	
	
	/*
	 * helper functions
	 */
	
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
