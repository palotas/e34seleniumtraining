package remoteWebdriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static util.SetupDriver.*;

public class RemoteWebdriverAbraxas {
	
	private final String URL="http://localhost:4444/wd/hub";
	private final String BROWSERNAME="chrome";
	private final String BROWSERVERSION="";
	private final String PLATFORM="LINUX";
	
	
	/*
	 * set capabilities in test 
	 * open abraxas.ch
	 * no assertions
	 * close browser
	 */
	@Test
	public void simpleRemoteTest() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        driver.get("http://abraxas.ch");
        driver.quit();		
	}
	
	/*
	 * same as above but
	 * assert that page title is correct
	 * close the browser 
	 */
	@Test
	public void remoteTestWithAssert() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        driver.get("http://abraxas.ch");
        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.ch");
        driver.quit();		
	}
	
	

	/*
	 * same as above but
	 * assert page title so that test fails
	 * close the browser 
	 * watch what is happening --> browser remains open
	 */
	
	@Test
	public void remoteTestWithAssertFalse() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        driver.get("http://abraxas.ch");
        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.fr");
        driver.close();		
	}
	
	
	
	/*
	 * same as above but
	 * use try/catch/finally
	 * assert page title so that test fails
	 * close the browser 
	 * NOTE: in order for the test to fail it needs to be explicitly failed in the catch block
	 * otherwise it will pass because exception is "absorbed" 
	 */	
	@Test
	public void remoteTestWithTryCatchFinally() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        
        try {
			driver.get("http://abraxas.ch");
	        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.fr");

		} catch (AssertionError e) {
			System.out.println("catching the assertion error");
			e.printStackTrace();
			Assert.fail();
		}
        finally {
            driver.quit();		        	
        }
	}
	
	
	
	/*
	 * use try/finally but no catch
	 */
	@Test
	public void remoteTestWithTryFinally() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        
        try {
			driver.get("http://abraxas.ch");
	        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.fr");

		} 
        finally {
            driver.quit();		        	
        }
	}
	
	
	/*
	 * take screenshot upon failure 
	 * catch exception and then rethrow it
	 */
	@Test
	public void remoteTestTakeScreenshotOnFailure() throws Exception
	{
		WebDriver driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("browserName", BROWSERNAME);
        capabilities.setCapability("version", BROWSERVERSION);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        
        
        try {
			driver.get("http://abraxas.ch");
	        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.fr");
		} 
        catch (AssertionError e) {
        	System.out.println("test failed...taking screenshot");
        	util.Screenshot.takeScreenshot(driver);
        	throw e; //rethrow the error again
        }
        finally {
            driver.quit();		        	
        }
	}
	
	
	/*
	 * use property file to set capabilities and driver
	 */
	@Test
	public void setupWithPropertyFile() throws Throwable {
		
		//use the setup method that reads the config from a property file
		WebDriver driver=util.SetupDriver.setup();
        
	       try {
				driver.get("http://abraxas.ch");
		        Assert.assertEquals(driver.getTitle(), "Home :: abraxas.fr");
			} 
	        catch (AssertionError e) {
	        	System.out.println("test failed...taking screenshot");
	        	util.Screenshot.takeScreenshot(driver);
	        	throw e; //rethrow the error again for further processing
	        }
	        finally {
	            driver.quit();		        	
	        }	
	}
	
	/*
	 * use expected exception
	 * this is useful i.e. when testing that certain elements
	 * are not present on a page
	 */
	@Test(expectedExceptions=NoSuchElementException.class)
	public void expectedExceptionTest() throws FileNotFoundException, IOException {

		WebDriver driver=util.SetupDriver.setup();
        
        try {
        	Reporter.log("Entering homepage now");
    		driver.get("http://www.abraxas.ch");
    		driver.findElement(By.id("nonexistingelement")); //this will throw a NoSuchElementException
    		Assert.assertEquals(driver.getTitle(), "Home :: abraxas.ch");
  
        }
        finally {
    		teardown(driver);
        }	
	}

}


