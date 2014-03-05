package selendroid;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelendroidTest {
	
	@Test
	public void selendroidEmulatorTest() throws Exception {

		//SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.8.0");
		SelendroidCapabilities capa = new SelendroidCapabilities().emulator("io.selendroid.testapp:0.8.0");
		
		WebDriver driver = new SelendroidDriver(capa);
		WebElement inputField = driver.findElement(By.id("my_text_field"));
		Assert.assertEquals("true", inputField.getAttribute("enabled"));
		inputField.sendKeys("Selendroid");
		Assert.assertEquals("Selendroid", inputField.getText());
		
		WebElement checkbox = driver.findElement(By.id("input_adds_check_box"));
		checkbox.click();
		Thread.sleep(3000);
		System.out.println("now hitting Menu button");
		new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	@Test
	public void selendroidDeviceTest() throws Exception {

		//SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.8.0");
		SelendroidCapabilities capa = new SelendroidCapabilities().device("io.selendroid.testapp:0.8.0");
		
		WebDriver driver = new SelendroidDriver(capa);
		WebElement inputField = driver.findElement(By.id("my_text_field"));
		Assert.assertEquals("true", inputField.getAttribute("enabled"));
		inputField.sendKeys("Selendroid");
		Assert.assertEquals("Selendroid", inputField.getText());
		
		WebElement checkbox = driver.findElement(By.id("input_adds_check_box"));
		checkbox.click();
		Thread.sleep(3000);
		System.out.println("now hitting Menu button");
		new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	@Test
	public void selendroidMobileWebTest() throws InterruptedException{

		WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.quit();
		
		
	}


}



