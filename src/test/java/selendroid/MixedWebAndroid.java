package selendroid;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import screenshot.DoScreenshot;



public class MixedWebAndroid {
	
	public final String IPADDRESS = "192.168.1.117";
	
	@Test(enabled=true)
	public void FirefoxWebBbv() throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://IPADDRESS:4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");
		DoScreenshot.remoteWebDriverScreenshot(driver);
		
		Thread.sleep(2000);

		driver.quit();
	}
	
	
	@Test(enabled=true)
	public void ChromeWebBbv() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://IPADDRESS:4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");
		Reporter.log("Page Title: " + driver.getTitle());
		
		DoScreenshot.remoteWebDriverScreenshot(driver);

		driver.quit();
	}
	
	@Test(enabled=true)
	public void AndroidWebBbv() throws IOException, InterruptedException {
		
		
		DesiredCapabilities capability = DesiredCapabilities.android();
	    capability.setCapability(SelendroidCapabilities.EMULATOR,false);

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://IPADDRESS:4444/wd/hub"), capability);
		
		try {
			driver.get("http://www.bbv.ch");
			Reporter.log("Page Title: " + driver.getTitle());
			
			WebElement link = driver.findElement(By.linkText("Industries"));
			link.click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "bbv Software Services AG | Industries");
			DoScreenshot.remoteWebDriverScreenshot(driver);
			//Thread.sleep(5000);
			
		}
		finally {
			driver.quit();
		}
}
	
	@Test(enabled=true)
	public void AndroidWebBbvDevice() throws IOException, InterruptedException {
		
		
		DesiredCapabilities capability = DesiredCapabilities.android();
	    capability.setCapability(SelendroidCapabilities.EMULATOR,false);

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://IPADDRESS:4444/wd/hub"), capability);
		
		try {
			driver.get("http://www.bbv.ch");
			Reporter.log("Page Title: " + driver.getTitle());
			
			WebElement link = driver.findElement(By.linkText("Industries"));
			link.click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "bbv Software Services AG | Industries");
			DoScreenshot.remoteWebDriverScreenshot(driver);
			Thread.sleep(5000);
			
		}
		finally {
			driver.quit();
		}
}
	
	
	
	
	@Test(enabled=false)
	public void androidAppTest() throws Exception {
	  SelendroidCapabilities capa =
	      new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
	  capa.setEmulator(false);
	  WebDriver driver = new SelendroidDriver(capa);
	  
	  try {
		  driver.findElement(By.id("startUserRegistration")).click();

		  // Enter user name
		  WebElement username = driver.findElement(By.id("inputUsername"));
		  username.sendKeys("johndoe");
		  DoScreenshot.remoteWebDriverScreenshot(driver);

		  
	  }
	  finally {
		  driver.quit();		  
	  }


	}
	
	
	@Test(enabled=false)
	public void openEbayApp() throws Exception {
	  SelendroidCapabilities capa =
	      new SelendroidCapabilities(
	          "com.ebay.mobile:2.4.0.15");
	  capa.setEmulator(true);
	  WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
	
	  Thread.sleep(5000);
	  driver.quit();
	}
	
	
	
}
