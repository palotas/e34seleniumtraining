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
	
	
	//Imbus training: start server with java -jar ios-server-standalone-0.6.6-SNAPSHOT.jar -port 4444 
	
	public final String OSXIP = "192.168.1.123";

	
	@Test
	public void safariWebTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("safari");
		capability.setPlatform(Platform.MAC);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), capability);

        driver.get("http://www.imbus.de");
		WebElement link = driver.findElement(By.linkText("BERATUNG"));
		link.click();

        Thread.sleep(5000);
        driver.quit();
	}
	

		@Test
		public void mobileSafariTest() throws InterruptedException, IOException {
	        
		    IOSCapabilities safari = IOSCapabilities.iphone("Safari");
		    safari.setCapability(IOSCapabilities.SIMULATOR, true);

	        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + OSXIP + ":4444/wd/hub"), safari);

	        driver.get("http://www.imbus.de");
			WebElement link = driver.findElement(By.linkText("BERATUNG"));
			link.click();
	        
	        Thread.sleep(2000);
	        DoScreenshot.remoteWebDriverScreenshot(driver);
	        
	        
	        Thread.sleep(1000);
	        driver.quit();
		}
		

}
