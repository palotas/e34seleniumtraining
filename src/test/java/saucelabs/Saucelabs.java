package saucelabs;

import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        capabilities.setCapability("platform", Platform.LINUX);
        this.driver = new RemoteWebDriver(
					  new URL("http://palotas:c69edf87-0701-41d3-8222-2268084734f1@ondemand.saucelabs.com:80/wd/hub"),
					  capabilities);
	}
	
	

	
	@Test 
	public void checkboxTest() throws InterruptedException {
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			WebElement checkBoxForm = driver.findElement(By.id("checkboxform"));
			
			//check how many checkboxes there are
			List<WebElement> checkBoxes = checkBoxForm.findElements(By.tagName("input"));
			Assert.assertEquals(3, checkBoxes.size());
			
			//Check if Salami (checkbox 1) is checked. If yes uncheck it
			Thread.sleep(2000);
			WebElement checkBox = checkBoxes.get(0);
			
			if(checkBox.isSelected()) {
				checkBox.click();				
			}
		
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
	}

	
	@AfterTest
	public void cleanup() throws Exception {
		driver.quit();
	}
}
