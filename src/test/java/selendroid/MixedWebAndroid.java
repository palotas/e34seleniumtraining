package selendroid;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import screenshot.DoScreenshot;
import util.UserData;

public class MixedWebAndroid {
	
	public final String ANDROIDIP = "192.168.1.117";
	public final String OSXIP = "192.168.1.118";
	
	@Test(enabled=true)
	public void FirefoxWebBbv() throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://"+ ANDROIDIP + ":4444/wd/hub"), capability);

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
				"http://"+ ANDROIDIP + ":4444/wd/hub"), capability);

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
				"http://"+ ANDROIDIP + ":4444/wd/hub"), capability);
		
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
				"http://"+ ANDROIDIP + ":4444/wd/hub"), capability);
		
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
	
	
	
	
	@Test(enabled=true)
	public void androidAppTest() throws Exception {
	  SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
	  capa.setEmulator(false);
	  WebDriver driver = new SelendroidDriver(new URL("http://"+ ANDROIDIP + ":4444/wd/hub"),capa);
	  
	  try {
		  driver.findElement(By.id("startUserRegistration")).click();

		  // Enter user name
		  WebElement username = driver.findElement(By.id("inputUsername"));
		  username.sendKeys("johndoe");
		  //DoScreenshot.remoteWebDriverScreenshot(driver);

		  
	  }
	  finally {
		  driver.quit();		  
	  }


	}
	
	//IOS TEST - Grid is currently on OSX VM
	@Test
	public void mobileSafariTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities safari = IOSCapabilities.iphone("Safari");
        //DesiredCapabilities safari = IOSCapabilities.ipad("Safari");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), safari);

        driver.get("http://www.bbv.ch");

        System.out.println(driver.getTitle());
        
        
        Thread.sleep(3000);
        driver.quit();
	}
	
	
	@Test
	public void iPhoneEbaySimulatorTest() throws Exception {

	    WebDriverWait elementWaiter;

	    DesiredCapabilities cap = IOSCapabilities.iphone("eBay");
		cap.setCapability(IOSCapabilities.LANGUAGE,"en");

	    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), cap);
	    elementWaiter = new WebDriverWait(driver, 20);

	    
	    WebElement agreeButton = driver.findElement(By.xpath("//UIAButton[contains(@name,'Agree')]"));
	    agreeButton.click();
	    
	    
	    WebElement signinButton = driver.findElement(By.xpath("//UIAButton[contains(@name,'Sign In')]"));
	    signinButton.click();

	    
	    //sign in
	    WebElement username = driver.findElement(By.xpath("//UIATextField[contains(@value,'User ID or email')]"));
	    username.sendKeys(UserData.getUsername());
	    
	    WebElement password = driver.findElement(By.xpath("//UIASecureTextField"));
	    password.sendKeys(UserData.getPassword()); 
	    	    
	    WebElement signinButton1 = driver.findElement(By.xpath("//UIAButton[contains(@name,'Sign In')]"));
	    signinButton1.click();
	    
	    
	    Thread.sleep(6000);
	    
	    WebElement myEbayButton = driver.findElement(By.xpath("//UIAButton[@name='My eBay']"));
	    Thread.sleep(1000);
	    myEbayButton.click();


	    WebElement profileButton = driver.findElement(By.xpath("//UIAButton[@name='Profile']"));
	    Thread.sleep(1000);
	    profileButton.click();
	    
	    Thread.sleep(3000);
	    
	    
	    WebElement userBadge = driver.findElement(By.xpath("//UIAStaticText[contains(@name,'tulipberlin')]"));
	    Assert.assertTrue(userBadge.getAttribute("name").contains("100%"));

	    
	    /*
	    // take a screenshot using the normal selenium api.
	    TakesScreenshot screen =(TakesScreenshot)new Augmenter().augment(driver);
	    File ss = new File("screenshot.png");
	    screen.getScreenshotAs(OutputType.FILE).renameTo(ss);
	    System.out.println("screenshot taken :"+ss.getAbsolutePath());
	    */
	    
	    Thread.sleep(5000);
	    
	    driver.quit();
	    

	}
	
	
	
	/*
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
	*/
	
	
	
}
