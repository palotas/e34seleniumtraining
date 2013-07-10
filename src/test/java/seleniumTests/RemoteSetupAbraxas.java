package seleniumTests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class RemoteSetupAbraxas {
	
	private final String GRIDURL="http://192.168.1.104:4444/wd/hub";
	private final String BROWSERNAME="firefox";
	private final String BROWSERVERSION="";
	private final String PLATFORM="MAC";
	
		
	@Test
	public void testAbraxas1() throws Exception {
	
		WebDriver driver;
		//setup
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(GRIDURL), capabilities);
        //driver.manage().window().maximize(); this may not be needed
        
        
        try {
    		driver.get("http://www.ebay.ch");
    		util.Screenshot.takeScreenshot(driver);
    		Assert.assertEquals("Home :: abraxas.ch", driver.getTitle());

        }
        catch (AssertionError e) { 
        	//System.out.println(e.getMessage());
        }
 
        finally {
    		driver.quit();	
        }		
	}
	
	
	@Test
	public void testAbraxas2() throws Throwable {
	
		WebDriver driver;
		
		
		//setup
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        driver = new RemoteWebDriver(new URL(GRIDURL), capabilities);
		
        
        try {
        	Reporter.log("Entering homepage now");
    		driver.get("http://www.abraxas.ch");
    		Reporter.log("making the assertion now");
    		Assert.assertEquals("Home :: abraxas.c", driver.getTitle());
  
    		//WebElement el=driver.findElement(By.id("test")); //will throw exception
    		

        }
        
        //use AssertionError or Throwable to be able to catch the assertion error
        catch (AssertionError e) {
        	util.Screenshot.takeScreenshot(driver);
        	System.out.println("ASSERTION ERROR");
        	
        	//Assert.fail(e.getMessage());
        }
        catch (NoSuchElementException e) {
        	System.out.println("NOSUCHELEMENT EXCEPTION");
        }
 
        finally {
    		driver.quit();	
        }		
	}
	
	@Test
	public void testAbraxas3() throws Exception {
	
		WebDriver driver;
		//setup
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        driver = new RemoteWebDriver(new URL(GRIDURL), capabilities);
		
        
        try {
    		driver.get("http://www.ebay.ch");
    		Assert.assertEquals("Home :: abraxas.ch", driver.getTitle());

        }
        catch (Exception e) {

        }
 
        finally {
    		driver.quit();	
        }		
	}

	@Test
	public void testAbraxas4() throws Exception {
	
		WebDriver driver;
		//setup
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        driver = new RemoteWebDriver(new URL(GRIDURL), capabilities);
		
        
        try {
    		driver.get("http://www.ebay.ch");
    		Assert.assertEquals("Home :: abraxas.ch", driver.getTitle());

        }
        catch (Exception e) {
        }
 
        finally {
    		driver.quit();	
        }		
	}
	
}


