package mobile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import screenshot.DoScreenshot;
import util.UserData;

public class IosTests {
	
	public final String OSXIP = "192.168.1.114";

	
	@Test
	public void safariWebTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("safari");
		capability.setPlatform(Platform.MAC);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), capability);

        driver.get("http://www.maibornwolff.de");
		WebElement link = driver.findElement(By.linkText("Was wir tun"));
		link.click();

        Thread.sleep(5000);
        driver.quit();
	}
	

		@Test
		public void mobileSafariTest() throws InterruptedException, IOException {
	        
		    IOSCapabilities safari = IOSCapabilities.iphone("Safari");
		    safari.setCapability(IOSCapabilities.SIMULATOR, false);

	        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), safari);

	        driver.get("http://www.maibornwolff.de");
			WebElement link = driver.findElement(By.linkText("Was wir tun"));
			link.click();
	        
	        Thread.sleep(2000);
	        DoScreenshot.remoteWebDriverScreenshot(driver);
	        
	        
	        Thread.sleep(1000);
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

		    
		    
		    Thread.sleep(5000);
		    
		    driver.quit();

		}
		



}
