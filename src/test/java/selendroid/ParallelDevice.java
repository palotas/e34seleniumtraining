package selendroid;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelDevice {

	
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
	
	
}
