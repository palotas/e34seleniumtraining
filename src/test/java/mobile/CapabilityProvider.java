package mobile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import screenshot.DoScreenshot;

public class CapabilityProvider {
	
	public String IP = "192.168.1.117";
	
/*	@DataProvider(name = "capsprovider")
	public Object[][] createData() {
	 return new Object[][] {
			   {"browserName", "iphone", "platform", "MAC"},
			   {"browserName", "android", "platform", "LINUX"},
			   {"browserName", "safari", "platform", "MAC"},
			   {"browserName", "firefox", "platform", "MAC"},
			   {"browserName", "chrome", "platform", "LINUX"},
			   {"browserName", "firefox", "platform", "LINUX"},
	 };
	}*/
	
	@DataProvider(name = "capsprovider", parallel=true)
	public Object[][] createData() {
	 return new Object[][] {
			   {"browserName", "firefox", "platform", "MAC"},
			   {"browserName", "safari", "platform", "MAC"},
			   {"browserName", "firefox", "platform", "LINUX"},
			   {"browserName", "chrome", "platform", "LINUX"},
	 };
	}
	
	
	@Test(dataProvider="capsprovider")
	public void capsProvider(String browserName, String browserValue, String platform, String platformValue) throws InterruptedException, IOException {
		System.out.println(browserName + " : " + browserValue + " : " + platform + " : " + platformValue);	

		DesiredCapabilities cap = buildDesiredCapability(browserName, browserValue, platform, platformValue);		
		WebDriver driver = new RemoteWebDriver(new URL("http://"+ IP + ":4444/wd/hub"), cap);

		driver.get("http://www.bbv.ch");
		DoScreenshot.remoteWebDriverScreenshot(driver);

		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=true)
	public void FirefoxWebBbv() throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://"+ IP + ":4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");
		DoScreenshot.remoteWebDriverScreenshot(driver);
		
		Thread.sleep(2000);

		driver.quit();
	}
	
	
	
	public DesiredCapabilities buildDesiredCapability(String browserName, String browserValue, String platform, String platformValue) {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(browserValue.contentEquals("iphone")) {
	        cap.setCapability("simulator", true);
	        cap.setCapability("CFBundleName", "Safari");
	        cap.setCapability("locale", "en_GB");
	        cap.setCapability("device", "iphone");
	        cap.setCapability("language", "en");
		}
		else {
			cap.setCapability(browserName, browserValue);
			cap.setCapability(platform, platformValue);			
		}
		
		return cap;
	}

}
