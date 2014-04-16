package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import util.UserData;

public class IosTests {
	
	public final String OSXIP = "192.168.1.117";

	
	
	
	//IOS TEST - Grid is currently on OSX VM
		@Test
		public void mobileSafariTest() throws MalformedURLException, InterruptedException {
	        
			DesiredCapabilities safari = IOSCapabilities.iphone("Safari");
			
			
	        //DesiredCapabilities safari = new DesiredCapabilities();
	        //safari.setCapability("simulator", true);
	        //safari.setCapability("CFBundleName", "Safari");
	        //safari.setCapability("locale", "en_GB");
	        //safari.setCapability("device", "iphone");
	        //safari.setCapability("language", "en");
	        
	        //System.out.println(safari.asMap());
	        //DesiredCapabilities safari = IOSCapabilities.ipad("Safari");
	        //RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.113.122:1111/wd/hub"), safari);
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
		
		@Test
		public void safariWebTest() throws MalformedURLException, InterruptedException {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("safari");
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), capability);

	        driver.get("http://www.bbv.ch");

	        System.out.println(driver.getTitle());
	        Thread.sleep(5000);
	        driver.quit();
		}


}
