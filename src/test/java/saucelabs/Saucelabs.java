package saucelabs;

import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Saucelabs {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("platform", Platform.MAC);
        this.driver = new RemoteWebDriver(
					  new URL("http://palotas:c69edf87-0701-41d3-8222-2268084734f1@ondemand.saucelabs.com:80/wd/hub"),
					  capabilities);
	}
	
	
	@Test
	public void mytest() {
		
		driver.get("http://www.imbus.de");
		Assert.assertEquals("Home :: abraxas.ch", driver.getTitle());
	}

	
	@AfterTest
	public void cleanup() throws Exception {
		driver.quit();
	}
}
