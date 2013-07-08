package seleniumTests;

import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoteSetupAbraxas {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		DesiredCapabilities capabillities = DesiredCapabilities.internetExplorer();
        capabillities.setCapability("platform", Platform.WIN8);
        capabillities.setCapability("browserName", "internet explorer");
        //capabillities.setCapability("version", "10.0.9200.16384");
        this.driver = new RemoteWebDriver(
					  new URL("http://192.168.1.104:4444/wd/hub"),
					  capabillities);
	}
	
	@Test
	public void mytest() {
		
		driver.get("http://www.abraxas.ch");
		Assert.assertEquals("Home :: abraxas.ch", driver.getTitle());
	}

	
	@AfterTest
	public void cleanup() throws Exception {
		driver.quit();
	}
}


