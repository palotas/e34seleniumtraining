package selendroid;

import java.net.URL;

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
	public void testShouldBeAbleToRegisterUser() throws Exception {
	  SelendroidCapabilities capa =
	      new SelendroidCapabilities(
	          "io.selendroid.testapp:0.9.0");
	  capa.setLocale("en_GB");
	  capa.setEmulator(false);
	  WebDriver driver = new SelendroidDriver(capa);
	  driver.findElement(By.id("startUserRegistration")).click();

	  // Enter user name
	  WebElement username = driver.findElement(By.id("inputUsername"));
	  username.sendKeys("johndoe");
	  driver.quit();
	}
	

	@Test(invocationCount=1)
	public void openEbayApp() throws Exception {
	  SelendroidCapabilities capa =
	      new SelendroidCapabilities(
	          "com.ebay.mobile:2.4.0.15");
	  capa.setEmulator(false);
	  WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
	
	  Thread.sleep(5000);
	  driver.quit();
	}

	
	@Test(invocationCount=1)
	public void testShouldBeAbleToRegisterUserGRID() throws Exception {
	  SelendroidCapabilities capa =
	      new SelendroidCapabilities(
	          "io.selendroid.testapp:0.9.0");
	  capa.setLocale("yy_XS"); //this is for some reason completely ignored
	  capa.setEmulator(false);
	  WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
	  driver.findElement(By.id("startUserRegistration")).click();

	  // Enter user name
	  WebElement username = driver.findElement(By.id("inputUsername"));
	  username.sendKeys("johndoe");
	  driver.quit();
	}
	
	@Test
	public void selendroidEmulatorTest() throws Exception {

		SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
		capa.setLocale("en_GB");
		capa.setEmulator(true);

		
		WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
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

		//SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
		SelendroidCapabilities capa = new SelendroidCapabilities().device("io.selendroid.testapp:0.9.0");
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
	public void selendroidMobileWebTest() throws Exception{

	    DesiredCapabilities capa = new SelendroidCapabilities();
	    capa.setCapability("emulator", false);
		capa.setBrowserName("android");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capa);


		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
		
		
	}


}



