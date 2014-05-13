package mobile;

import io.selendroid.SelendroidCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import screenshot.DoScreenshot;

public class CapabilityProvider {
	
	public String IP = "192.168.1.114";
		
	@DataProvider(name = "capsprovider", parallel=true)
	public Object[][] createData() {
	 return new Object[][] {
			   {"browserName", "iphone", "platform", "MAC"},
			   {"browserName", "safari", "platform", "MAC"},
			   {"browserName", "firefox", "platform", "LINUX"},
			   {"browserName", "chrome", "platform", "LINUX"},
			   {"browserName", "android", "platform", "ANY"},
	 };
	}
	
	
	@Test(dataProvider="capsprovider")
	public void writeOnceRunEverywhere(String browserName, String browserValue, String platform, String platformValue) throws InterruptedException, IOException {
		System.out.println(browserName + " : " + browserValue + " : " + platform + " : " + platformValue);	

		DesiredCapabilities cap = buildDesiredCapability(browserName, browserValue, platform, platformValue);		
		WebDriver driver = new RemoteWebDriver(new URL("http://"+ IP + ":4444/wd/hub"), cap);

		driver.get("http://www.maibornwolff.de");
		WebElement link = driver.findElement(By.linkText("Was wir tun"));
		link.click();
		
		Reporter.log(driver.getTitle());
		
		Thread.sleep(2000);
		
		DoScreenshot.remoteWebDriverScreenshot(driver);

		Thread.sleep(1000);
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
		if(browserValue.contentEquals("android")) {
			cap.setCapability(browserName, browserValue);
		    cap.setCapability(SelendroidCapabilities.EMULATOR,false);
		}
		else {
			cap.setCapability(browserName, browserValue);
			cap.setCapability(platform, platformValue);			
		}
		
		return cap;
	}

}
