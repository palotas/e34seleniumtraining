/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static sbox.Settings.HUB;

public class SboxDemo {


	@Test
	public void anaplan() throws MalformedURLException {

		ChromeOptions chromeOpts = new ChromeOptions();
		chromeOpts.setExperimentalOption("w3c", true); //if set to false then session creation works

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("e34:token", "30e75a42-817d-4c");
		capabilities.setCapability("version", "75");

		RemoteWebDriver wrapped = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capabilities);
		EventFiringWebDriver driver = new EventFiringWebDriver(wrapped);
		driver.register(new WebDriverEventListener() {
			long startNavigation;
			long startFindBy;
			long startClick;

			@Override
			public void beforeAlertAccept(WebDriver driver) {

			}

			@Override
			public void afterAlertAccept(WebDriver driver) {

			}

			@Override
			public void afterAlertDismiss(WebDriver driver) {

			}

			@Override
			public void beforeAlertDismiss(WebDriver driver) {

			}

			@Override
			public void beforeNavigateTo(String url, WebDriver driver) {
				startNavigation = System.currentTimeMillis();
			}

			@Override
			public void afterNavigateTo(String url, WebDriver driver) {
				System.out.println("navigate to " + url + " =" + (System.currentTimeMillis() - startNavigation) + "ms");
			}

			@Override
			public void beforeNavigateBack(WebDriver driver) {

			}

			@Override
			public void afterNavigateBack(WebDriver driver) {

			}

			@Override
			public void beforeNavigateForward(WebDriver driver) {

			}

			@Override
			public void afterNavigateForward(WebDriver driver) {

			}

			@Override
			public void beforeNavigateRefresh(WebDriver driver) {

			}

			@Override
			public void afterNavigateRefresh(WebDriver driver) {

			}

			@Override
			public void beforeFindBy(By by, WebElement element, WebDriver driver) {
				startFindBy = System.currentTimeMillis();
			}

			@Override
			public void afterFindBy(By by, WebElement element, WebDriver driver) {
				System.out.println("find by  " + by + " =" + (System.currentTimeMillis() - startFindBy) + "ms");

			}

			@Override
			public void beforeClickOn(WebElement element, WebDriver driver) {
				startClick = System.currentTimeMillis();
			}

			@Override
			public void afterClickOn(WebElement element, WebDriver driver) {
				System.out.println("click  =" + (System.currentTimeMillis() - startClick) + "ms");

			}

			@Override
			public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

			}

			@Override
			public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

			}

			@Override
			public void beforeScript(String script, WebDriver driver) {

			}

			@Override
			public void afterScript(String script, WebDriver driver) {

			}

			@Override
			public void beforeSwitchToWindow(String windowName, WebDriver driver) {

			}

			@Override
			public void afterSwitchToWindow(String windowName, WebDriver driver) {

			}

			@Override
			public void onException(Throwable throwable, WebDriver driver) {

			}

			@Override
			public <X> void beforeGetScreenshotAs(OutputType<X> target) {

			}

			@Override
			public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

			}

			@Override
			public void beforeGetText(WebElement element, WebDriver driver) {

			}

			@Override
			public void afterGetText(WebElement element, WebDriver driver, String text) {

			}
		});

		System.out.println(wrapped.getSessionId());
		for (int i = 0; i < 10; i++) {
			driver.get("https://element34.com");
			//WebElement el = driver.findElement(By.cssSelector("#mainNavigation a"));
			//el.click();
		}
		driver.quit();
	}






	@Test
	public void timeout() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();

		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability("browserName", "firefox");
		caps.setCapability("e34:l_testName", "check primint");
		caps.setCapability("e34:video", true);
		caps.setCapability("e34:token", "99da6e20-a785-45");
		caps.setCapability("build", "Build-1563859390886");
		caps.setCapability("acceptSslCerts", true);


		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);
		System.out.println(driver.getSessionId().toString());

		driver.get("https://element34.com");
		Thread.sleep(20000);
		System.out.println("timeout works");
		driver.quit();

	}

	@Test
	public void jpm() throws MalformedURLException, InterruptedException {


		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("pdfjs.disabled", false);
		options.addPreference("pdfjs.enabledCache.state", true);

		options.setCapability("e34:token", "df170fe7-811e-43");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), options);
		driver.get("https://self-signed.e34.lan/www/download.html");
		driver.findElement(By.id("download_pdf")).click();


		//DesiredCapabilities caps = DesiredCapabilities.firefox();
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("pdfjs.disabled", false);
		//caps.setCapability(FirefoxDriver.PROFILE, profile);

//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("e34:token", "cfed0a5b-9b31-4f");
//		caps.setCapability("e34:video",true);
//		caps.setCapability("e34:l_testName", "Bytesource Test");

		//RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);
		//WebDriverWait wait =  new WebDriverWait(driver, 10);
		//driver.get("https://element34.com");
		//driver.get("https://seleniumbox.com/public/whitepaper-enterprise-selenium-infrastructure.pdf");

		//driver.get("https://www.atlassian.com/purchase/product/confluence");
		Thread.sleep(3000); //just to keep the browser open for a bit longer
		driver.quit();
	}

	@Epic("Selenium Box Demo Tests")
	@Feature("Open website ")
	@Story("Users should be able to click on the website")
	@Severity(SeverityLevel.MINOR)
	@Test(invocationCount = 1, threadPoolSize = 10)
	public void webtest() throws IOException, InterruptedException {

		DesiredCapabilities caps = DesiredCapabilities.chrome();

		//FirefoxOptions caps = new FirefoxOptions();
		caps.setCapability("browserName", "chrome");
		caps.setCapability("e34:token", "99da6e20-a785-45");

		//caps.setCapability("version", "50");
		//caps.setCapability("platformName", "windows");
		//caps.setCapability("e34:token", " 99da6e20-a785-45");
		caps.setCapability("e34:video",true);
		caps.setCapability("e34:l_testName", "Selenium Box demo test");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);

		for (int i= 0; i < 1; i++) {
			driver.get("https://www.jpmorganchase.com/");
			Thread.sleep(2000);
		}

		System.out.println("session ID: " + driver.getSessionId());
		addVideoLink(driver);
		driver.quit();
	}


	@Test(enabled = true, dataProvider = "browserProvider", dataProviderClass = TestData.class)
	public void webTestWithMultipleBrowsers(DesiredCapabilities caps) throws IOException, InterruptedException {

		caps.setCapability("e34:token", "aa43a67a-0303-4e");
		caps.setCapability("e34:video",true);
		caps.setCapability("e34:l_testName", "SBOX multi browser test");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		for (int i= 0; i < 5; i++) {
			driver.get("https://www.jpmorganchase.com/");
			Thread.sleep(2000);
			driver.findElement(By.id("searchTextField")).sendKeys(Keys.chord("Gold" + Keys.ENTER));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("matched-documents")));
			Assert.assertEquals(driver.findElement(By.id("matched-documents")).getText(), "Your search matched 69 documents.");

			Thread.sleep(2000);

		}
		addVideoLink(driver);
		driver.quit();
	}



	@Epic(" Mobile Tests")
	@Feature("Open  mobile website ")
	@Story("Users should be able to see the mobile version of the  website")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 1, threadPoolSize = 10)
	public void mobileWebTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability("e34:token", "99da6e20-a785-45");
		caps.setCapability("e34:video", true);
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability(CapabilityType.BROWSER_VERSION, "70");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);
		driver.get("https://www.lloydsbankinggroup.com/");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		addVideoLink(driver);
		driver.quit();
	}







	@Epic("Mobile Tests")
	@Feature("Open mobile website ")
	@Story("Users should be able to see the mobile version of the website on multiple devices")
	@Severity(SeverityLevel.NORMAL)
	@Test(invocationCount = 1, threadPoolSize = 10, dataProvider = "mobileDataProvider", dataProviderClass = TestData.class)
	public void mobileWebTestWithDataProvider(DesiredCapabilities caps) throws MalformedURLException, InterruptedException {

		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "mobileWeb  - " + caps.getCapability(MobileCapabilityType.DEVICE_NAME) + " Android " + caps.getCapability(MobileCapabilityType.PLATFORM_VERSION));

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		Thread.sleep(2000);
		driver.get("https://www.jpmorganchase.com/");
		Thread.sleep(2000);
		driver.get("https://element34.com");
		addVideoLink(driver);
		driver.quit();
	}





	@Test(invocationCount = 1, threadPoolSize = 10,enabled = false)
	public void nativeAppTest() throws IOException, InterruptedException {
		String appLocation = "http://static.element34.net/mobile/demo_apks/ApiDemos-debug.apk";
		mobileNativeTest(appLocation);
	}

	private void mobileNativeTest(String appLocation) throws MalformedURLException, InterruptedException {
		String threadInfo = String.format("%s - %s", Thread.currentThread().getId(), Thread.currentThread().getName());
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		caps.setCapability("e34:token", "617a27e4-c74c-46");

		caps.setCapability("e34:app", appLocation);
		caps.setCapability("e34:video", true);
		caps.setCapability("e34:l_testName", "nativeApp " + threadInfo);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");

		AndroidDriver driver = new AndroidDriver(new URL("http://vm-106.element34.net/wd/hub"), caps);
		Wait<AndroidDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.ignoring(NotFoundException.class)
				.ignoring(WebDriverException.class);
		try {
			// For demos, change cycles and sleep so the test takes longer and more containers can be seen in the live view.
			int cycles = 3;
			long sleep = 2000;
			for (int i = 0; i < cycles; i++) {
				MobileElement accessibility = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility"));
				Thread.sleep(sleep);
				accessibility.click();
				Thread.sleep(sleep);
				MobileElement accessibilityService = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
				Thread.sleep(sleep);
				accessibilityService.click();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementById("io.appium.android.apis:id/button"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				MobileElement app = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("App"));
				Thread.sleep(sleep);
				app.click();
				Thread.sleep(sleep);
				MobileElement alertDialogs = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
				Thread.sleep(sleep);
				alertDialogs.click();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("List dialog"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
				wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
				Thread.sleep(sleep);
				driver.navigate().back();
				Thread.sleep(sleep);
			}
		} finally {
			addVideoLink(driver);
			driver.quit();
		}
	}





	@Test(enabled = true, dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 1)
	public void loadTest(String url) throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("e34:token" , "aa43a67a-0303-4e");
		options.setCapability("e34:l_testName", "load test");
		options.setCapability("version", "");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 1000));

		driver.quit();
	}

	@Test(enabled = false, dataProvider = "tokenProvider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 220)
	public void userfiltering(ChromeOptions options) throws IOException, InterruptedException {

		options.setCapability("e34:l_testName", "user filtering test");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);

		driver.get("http://static.element34.net/e34");
		System.out.println(driver.getTitle());
		Thread.sleep(30000);

		driver.quit();
	}









	private void addVideoLink(RemoteWebDriver driver) {
		io.qameta.allure.model.Link link = new io.qameta.allure.model.Link();
		link.setName("VIDEO URL");
		link.setUrl(HUB + "/videos/" + driver.getSessionId() + ".mp4");
		Allure.addLinks(link);
	}

}
