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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MixedWebAndroid {

	@Test
	public void FirefoxWebGridfusion() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.ebay.com");

		Thread.sleep(2000);

		driver.quit();
	}
	
	
	
	@Test
	public void FirefoxWebBbv() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");

		Thread.sleep(2000);

		driver.quit();
	}
	
	
	@Test
	public void ChromeWebBbv() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}
	
	@Test
	public void AndroidWebBbv() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("android");
		//capability.setEmulator(false);


		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.bbv.ch");
		Reporter.log("Page Title: " + driver.getTitle());
		
		WebElement link = driver.findElement(By.linkText("Industries"));
		link.click();
		Assert.assertEquals(driver.getTitle(), "bbv Software Services AG | Willkommen");
		Thread.sleep(5000);

		driver.quit();
	}
	
	
	
	
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
	  capa.setEmulator(true);
	  WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
	
	  Thread.sleep(5000);
	  driver.quit();
	}
	
	
	//does not work currently in GRID
	/*
	@Test
	public void selendroidMobileWebTest() throws Exception{

	    DesiredCapabilities capa = new SelendroidCapabilities();
	    capa.setCapability("emulator", true);
		capa.setBrowserName("android");
		//capa.setCapability("locale", "en_GB");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capa);


		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}
	*/
	
}
