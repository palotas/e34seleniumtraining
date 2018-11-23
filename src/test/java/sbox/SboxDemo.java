/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import com.google.common.base.Stopwatch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static sbox.Settings.HUB;

public class SboxDemo {


	@Test
	public void differentUsers() throws IOException, InterruptedException {

		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("e34:token", "19705d15-03b8-4f");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		//WebDriverWait wait =  new WebDriverWait(driver, 10);
		//driver.manage().window().maximize();


		for (int i= 0; i < 2; i++) {
			driver.get("https://element34.com");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Consulting")).click();
			Thread.sleep(2000);
			driver.get("https://element34.com");
			driver.findElement(By.linkText("Training")).click();
			Thread.sleep(2000);


		}
		driver.quit();
	}


	@Test(invocationCount = 1, threadPoolSize = 10)
	public void mobileWebTest() throws MalformedURLException, InterruptedException {
		String threadInfo = String.format("%s - %s", Thread.currentThread().getId(), Thread.currentThread().getName());
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		// caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "mobileWeb " + threadInfo);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(25000);
		driver.quit();	}


	@Test
	public void mobile() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability(CapabilityType.VERSION, "67");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X GPS");

		caps.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		caps.setCapability("e34:video" , true);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.quit();
	}


	@Test
	public void demoSbox() throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f"); //babbage / adoring edison
		options.setCapability("e34:video" , true);
		options.setCapability("e34:l_testName", "sbox demo test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();


		for (int i= 0; i < 2; i++) {
			driver.get("https://www.commbank.com.au/banking.html?ei=mv_banking");
			Thread.sleep(2000);
			driver.findElement(By.className("log-on-text")).click();
			Thread.sleep(2000);
			WebElement iFrame = driver.findElement(By.className("netbank-login"));
			driver.switchTo().frame(iFrame);
			driver.findElement(By.id("txtMyClientNumber_field")).sendKeys("123456");
			Thread.sleep(2000);
			driver.findElement(By.id("txtMyPassword_field")).sendKeys("12345");
			Thread.sleep(2000);

		}
		driver.quit();
	}

	@Test(dataProvider = "mobileprovider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 4/*, dataProvider = "ports"*/)
	public void readingListNativeAppTest(String device/*int portAppium, int portWebDriverAgent, String device, String webUrl*/) throws IOException, InterruptedException {


		String threadInfo = String.format("%s - %s", Thread.currentThread().getId(), Thread.currentThread().getName());

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
		caps.setCapability("e34:l_testName", "Reading List " + threadInfo);
		caps.setCapability(MobileCapabilityType.APP, "/Users/e34/ReadingList.app.zip");
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

		Stopwatch watch = Stopwatch.createStarted();
		System.out.println("Starting");
		IOSDriver driver = new IOSDriver(new URL(HUB + "/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		long start = System.currentTimeMillis();
		try {
			System.out.println("Started in: " + watch.elapsed(TimeUnit.SECONDS));
			SessionId id = driver.getSessionId();
			System.out.println(String.format("Session ID: %s", id.toString()));
			Wait<IOSDriver> wait = new FluentWait<>(driver)
					.withTimeout(10,SECONDS)
					.ignoring(NotFoundException.class);

			MobileElement addBook = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("Add"));
			addBook.click();

			MobileElement searchOnline = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("Search Online"));
			searchOnline.click();

			MobileElement searchField = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("Search"));
			searchField.sendKeys("Selenium");
			searchField.sendKeys(Keys.ENTER);

			WebElement element = null;
			for (int i = 0; i < 2; i++) {
				System.out.println(threadInfo + "A");
				element = wait.until(d -> d.findElement(By.className("XCUIElementTypeCell")));
				System.out.println(threadInfo + "B");
				Thread.sleep(1000);
			}
			element.click();
			System.out.println(threadInfo + "C");

			System.out.println(threadInfo + " Before clicking done");
			MobileElement doneAdding = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("Done"));
			doneAdding.click();
			System.out.println(threadInfo + " After clicking done");

			wait.until(webDriver -> driver.findElements(By.className("XCUIElementTypeCell")).size() == 1);
			List<MobileElement> readingList = wait.until(webDriver -> driver.findElements(By.className("XCUIElementTypeCell")));
			readingList.get(0).click();
			System.out.println(threadInfo + " Clicking on the first one from my list");

			MobileElement startBook = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("START"));
			startBook.click();
			System.out.println(threadInfo + " Starting book");

			MobileElement finishBook = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("FINISH"));
			finishBook.click();
			System.out.println(threadInfo + " Finishing book");

			driver.navigate().back();
			System.out.println(threadInfo + " Going back");

			MobileElement finishedBooks = (MobileElement) wait.until(webDriver -> driver.findElementByAccessibilityId("Finished"));
			finishedBooks.click();
			System.out.println(threadInfo + " Listing finished books");
		} finally {
			System.out.println("Total elapsed time: " + watch.elapsed(SECONDS));
			System.out.println("Duration: " + ((System.currentTimeMillis() - start) / 1000));
			driver.quit();
		}

	}

	@Test(invocationCount = 1)
	public void safariDemo() throws IOException, InterruptedException {


		DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		caps.setCapability("e34:video" , true);
		caps.setCapability("e34:l_testName", "safari test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		System.out.println(driver.getSessionId());


		try {
			for (int i= 0; i < 2; i++) {
				Thread.sleep(1000);
				driver.get("https://www.zkb.ch");
				driver.getTitle();
				Thread.sleep(2000);
				driver.findElement(By.id("standortLink")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Jobs")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("field-globalsearch")).sendKeys("Gold\n");
				Thread.sleep(5000);


//			driver.get("http://static.element34.net/the-internet");
//			driver.getTitle();
//
//
//			driver.get("http://www.bmw-brilliance.cn/cn/en/index.html");
//			Thread.sleep(2000);
//			driver.findElement(By.linkText("Company Information")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.linkText("Careers")).click();
//
//		}
//
//
//		wait.until(ExpectedConditions.titleIs("BMW Brilliance：Working in BMW Brilliance"));
//		Assert.assertEquals(driver.getCurrentUrl(), "http://www.bmw-brilliance.cn/cn/en/hr/index.html" );
//		Thread.sleep(5000);
			}

		}

		finally {
			driver.quit();

		}

	}








	@Test
	public void demoChrome() throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f");
		options.setCapability("e34:video" , true);
		options.setCapability("e34:l_testName", "ZKB Chrome");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		System.out.println(driver.getSessionId());

		try {

		for (int i=0; i<3; i++) {

				Thread.sleep(1000);

				//first driver.get() after starting the browser
				driver.get("YOUR-URL");
				while (driver.getPageSource().contains("ERR_NETWORK_CHANGED")) {
					Thread.sleep(1000);
					System.out.println("ERR_NETWORK_CHANGED encountered - retrying...");
					driver.get("YOUR-URL");
				}

				driver.getTitle();
				Thread.sleep(2000);
				driver.findElement(By.id("standortLink")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Jobs")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("field-globalsearch")).sendKeys("Gold");
				driver.findElement(By.id("field-globalsearch-btn")).click();
			}
		}

		finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}








	@Test(dataProvider = "sBoxBrowsersProvider", dataProviderClass = TestData.class)
	//@Severity(SeverityLevel.CRITICAL)
	public void test03(DesiredCapabilities capability) throws IOException, InterruptedException {

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);

		//logger.info("Test running on SeleniumBox. Browser: "+capability.getBrowserName().toUpperCase()
		//		+" Version: "+driver.getCapabilities().getVersion());

		String seleniumBoxSessionID = driver.getSessionId().toString();
		//logger.info("Test Video URL: "+seleniumBoxUrl+"videos/"+seleniumBoxSessionID+".mp4");

		driver.get("https://www.bmw-brilliance.com");
		Thread.sleep(20000);
		System.out.println(("Page Title: " + driver.getTitle()));

		driver.quit();
	}


	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class, invocationCount = 150, threadPoolSize = 20)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("video", true);
		caps.setCapability("e34:token", "19705d15-03b8-4f");
		caps.setCapability("e34:l_testName", "CBA - " + caps.getBrowserName() + "  " + caps.getVersion());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.manage().window().maximize();

		driver.get("https://element34.com");

//		for (int i= 0; i < 5; i++) {
//			driver.get("https://www.commbank.com.au/banking.html?ei=mv_banking");
//			Thread.sleep(2000);
//			driver.findElement(By.className("log-on-text")).click();
//			Thread.sleep(2000);
//			WebElement iFrame = driver.findElement(By.className("netbank-login"));
//			driver.switchTo().frame(iFrame);
//			driver.findElement(By.id("txtMyClientNumber_field")).sendKeys("123456");
//			Thread.sleep(2000);
//			driver.findElement(By.id("txtMyPassword_field")).sendKeys("12345");
//			Thread.sleep(6000);
//
//		}
		driver.quit();
	}






	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 40, threadPoolSize = 40)
	public void loadTest(String url) throws IOException, InterruptedException {


		//FirefoxOptions options = new FirefoxOptions();
		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "19705d15-03b8-4f");
		options.setCapability("e34:l_testName", "load test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}

}
