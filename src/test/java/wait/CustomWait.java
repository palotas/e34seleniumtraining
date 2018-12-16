/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package wait;

import elnadv.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CustomWait extends BaseTest {

	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/workspace/e34seleniumtraining/resources/linux/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/workspace/e34seleniumtraining/resources/linux/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			case "Windows 7":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\Downloads\\geckodriver");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\Downloads\\chromedriver.exe");
				break;

			case "Windows 10":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}



	@Test(invocationCount=1)
	public void implicitWaitHeroku() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();


		try {
			//first try without implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

			driver.findElement(By.cssSelector("#start > button")).click();
			Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(), "Hello World!");
			System.out.println(driver.findElement(By.cssSelector("#finish")).getText());			
		}
		finally {
			driver.quit();
		}
	}
	
	
	
	
	@Test(invocationCount=1)
	public void explicitWait() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
			
			driver.findElement(By.cssSelector("#start > button")).click();

			Thread.sleep(3000);

			//first try without explicit wait
			wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish"))));
			System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
		}
		finally {
			driver.quit();
		}
	}

	@Test
	public void fluentWait() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		WebDriver driver = new ChromeDriver();



		driver.get("about:policy");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, SECONDS)
				.pollingEvery(5, SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		WebElement reload = wait.until(new Function<WebDriver, WebElement>()
		{

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("reload-policies"));
			}
		});


		reload = driver.findElement(By.id("reload-policies"));
		System.out.println(reload.getText());
		driver.get("about:policy");
		System.out.println(reload.getText());
		System.out.println(reload.getText());
		driver.quit();





	}
	// Waiting 30 seconds for an element to be present on the page, checking

	// for its presence once every 5 seconds.






}
