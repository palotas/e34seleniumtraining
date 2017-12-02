/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

//import com.element34.webdriver.DriverAutoLogAugmenter;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static elnadv.Helpers.sleepTight;
import static sbox.Helpers.getDownloadedFileName;
import static sbox.Helpers.getInternalSessionId;
import static sbox.Helpers.screenshot;
import static sbox.Settings.HUB;

public class SboxTests {

	@Test
	public void demo() throws IOException, InterruptedException {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("video", true);
		capability.setCapability("e34_token", "57ffedec");
		capability.setCapability("e34_per_test_timeout_ms", 300000);


		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		driver.manage().window().maximize();
		printLiveViewURL(driver);
		printVideoURL(driver);


		for (int i=0; i<1; i++) {
			driver.get("https://www.raiffeisen.at");
			driver.getTitle();
			Thread.sleep(1000);

			driver.get("https://google.com");
			driver.getTitle();
			Thread.sleep(1000);
		}

		driver.quit();
	}


	@Test(dataProvider = "chromeVersions", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 1)
	public void chromeWithDifferentVersionsTest(String version) throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setCapability("e34:token", "57ffedec");
		capability.setCapability("e34_per_test_timeout_ms", 300000);


		capability.setBrowserName("chrome");
		capability.setVersion(version);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		driver.manage().window().fullscreen();

		System.out.println("Browser version: " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

		//replace with company specific URL
		driver.get("https://seleniumbox.com");
		System.out.println("Video URL: " + HUB + "/videos/" + driver.getSessionId() + ".mp4");

		//leave browser open for 5 seconds and close browser afterwards
		Thread.sleep(5000);
		driver.quit();
	}

	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 5)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws IOException, InterruptedException {

		//enable video recording
		caps.setCapability("video", true);
		caps.setCapability("e34:token", "57ffedec");
		caps.setCapability("e34_per_test_timeout_ms", 300000);



		//replace URL with company specific entry point
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), caps);
		driver.manage().window().maximize();
		System.out.println("Live View URL > " + HUB + ":443/ui/liveview?session=" + driver.getSessionId().toString());


		//replace with company specific URL
		driver.get("https://sbb.ch");

		printVideoURL(driver);

		//leave browser open for 5 seconds and close browser afterwards
		Thread.sleep(5000);
		driver.quit();
	}


	@Test(invocationCount = 5, threadPoolSize = 5)//(dataProvider = "tokens", dataProviderClass = TestData.class, invocationCount = 1)
	public void singleTest(/*String token*/) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		//capability.setCapability("version", "56");
		capability.setCapability("e34:video", true);
		capability.setCapability("e34:token", "57ffedec");
		//capability.setCapability("e34_token", token);
		capability.setCapability("e34:l_testName", "mpalotas");
		//capab	ility.setCapability("e34_per_test_timeout_ms", 300000);
//		capability.setVersion("n-1");
		//capability.setCapability("l_testName", "SBOX Demo Test");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();
		printLiveViewURL(driver);
		printVideoURL(driver);

		for(int i = 0; i < 1; i++) {
			driver.get("https://infoq.com");
			driver.getTitle();
			driver.getCapabilities();
			driver.getPageSource();
			Thread.sleep(1500);
			driver.get("https://sbb.ch");
			driver.getTitle();
			driver.getCapabilities();
			driver.getPageSource();
			Thread.sleep(10000);

		}

//		driver.get("https://stackoverflow.com/questions/27241186/how-to-determine-when-document-has-loaded-after-loading-external-css");
//
//		for (int i = 0; i < 5; i++) {
//			driver.getTitle();
//			driver.getCurrentUrl();
//			driver.get("https://google.com");
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			System.out.println(js.executeScript("return document.readyState"));
//			Thread.sleep(1000);
//			driver.get("https://stackoverflow.com/questions/27241186/how-to-determine-when-document-has-loaded-after-loading-external-css");
//		}

		driver.quit();
	}


	@Test(dataProvider = "tokens", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 100)
	public void testnames(String token) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		//capability.setCapability("version", "56");
		capability.setCapability("video", true);
		//capability.setCapability("e34_token", "2825c4dd");
		capability.setCapability("e34_token",  token);
		capability.setCapability("e34:l_testName", "my test");
		//capab	ility.setCapability("e34_per_test_timeout_ms", 300000);
//		capability.setVersion("n-1");
		//capability.setCapability("l_testName", "SBOX Demo Test");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();
		printLiveViewURL(driver);
		printVideoURL(driver);

		driver.get("https://sbb.ch");

		Thread.sleep(20000);

		driver.quit();
	}



	@Test
	public void fileDownload() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		printVideoURL(driver);

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(Helpers.FileToBePresent("some-file.txt"));
		//wait.until(Helpers.FileToBeSize(307)); this is not working at themoment due to a conflict with restassured "size"

		driver.get(HUB + "/downloads/" + getInternalSessionId(driver) + "/" + getDownloadedFileName(driver));

		driver.quit();
	}

	@Test
	public void screenshotTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		printVideoURL(driver);

		driver.get("http://the-internet.herokuapp.com/download");
		screenshot(driver);

		driver.quit();
	}



	@Test
	public void buildFFProfile() throws MalformedURLException {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxProfile localeProfile = new FirefoxProfile();
		localeProfile.setPreference("general.useragent.locale", "en-GB");

		// turn off antialising
		// localeProfile.setPreference(
		// "gfx.font_rendering.cleartype_params.rendering_mode", 1);

		// Turn off stupid 'Allow Pasting' check
		localeProfile.setPreference("devtools.selfxss.count", 100);

		localeProfile.setPreference("intl.accept_languages", "en-GB");
		capabilities.setCapability(FirefoxDriver.PROFILE, localeProfile);
		capabilities.setVersion("47");
		capabilities.setCapability(CapabilityType.OVERLAPPING_CHECK_DISABLED, true);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), capabilities);

		driver.get("http://www.google.com");

		driver.quit();

	}


//	@Test
//	public void reportingTest() throws MalformedURLException {
//
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setCapability("video", true);
//		capability.setBrowserName("chrome");
//		WebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
//		driver = new DriverAutoLogAugmenter().augment(driver);
//
//		driver.get("http://the-internet.herokuapp.com/download");
//		sleepTight(1000);
//		driver.get("https://google.com");
//		sleepTight(1000);
//		driver.get("http://www.spiegel.de");
//		sleepTight(1000);
//		driver.get("https://bytesource.net/en/");
//		sleepTight(1000);
//		driver.get("https://oebb.at");
//		sleepTight(1000);
//
//		driver.quit();
//
//	}


	private void printVideoURL(RemoteWebDriver driver) {
		System.out.println("Video URL - " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion() + " : " + "https://vm-106.element34.net/videos/" + driver.getSessionId() + ".mp4");
	}

	private void printLiveViewURL(RemoteWebDriver driver) {
		System.out.println("Live View URL > " + HUB + ":443/ui/liveview?session=" + driver.getSessionId().toString());
	}


	@Test(enabled = true)
	public void ciscoTest() {
		MutableCapabilities options = new FirefoxOptions();
		//options.setCapability("e34:geckodriver", "0.19.0");
		options.setCapability("browserName", "firefox");
		options.setCapability("version", "52");
		options.setCapability("e34:token","57ffedec");
		options.setCapability("e34:video", true);


			RemoteWebDriver driver = null;
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("browserName", "firefox");
			dc.setCapability("version", "52");
			dc.setCapability("e34:token","57ffedec");
			dc.setCapability("e34:video", true);
			try {
				//driver = new RemoteWebDriver(new URL("http://seleniumbox.cisco.com/wd/hub"), dc);
				driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
			}
			catch (MalformedURLException e) {
				System.out.println(e);
			}

			try {
				driver.manage().window().setSize(new Dimension(1024, 768)); //Works fine with firefox v47
				System.out.println("window.setSize working");
			}
			catch(Exception e) {
				e.printStackTrace();
//           Raises following exception in case of firefox v52:
//           org.openqa.selenium.WebDriverException: setWindowRect
//           Build info: version: '3.4.0', revision: 'unknown', time: 'unknown'
//           System info: host: 'c64219d7e34d', ip: '172.17.0.4', os.name: 'Linux', os.arch: 'amd64', os.version: '3.10.0-327.36.3.el7.x86_64', java.version: '1.8.0_111'
//           Driver info: org.openqa.selenium.firefox.FirefoxDriver
//           Capabilities [{moz:profile=/tmp/rust_mozprofile.tYnC2vOIbWOn, rotatable=false, timeouts={implicit=0.0, page load=300000.0, script=30000.0}, pageLoadStrategy=normal, platform=ANY, specificationLevel=0.0, moz:accessibilityChecks=false, acceptInsecureCerts=false, browserVersion=52.0.2, platformVersion=3.10.0-327.36.3.el7.x86_64, moz:processID=91.0, browserName=firefox, javascriptEnabled=true, platformName=linux}]

			}
			try { //Works fine with firefox v47
				System.out.println(String.format("%s LiveView: ","DEMO",driver.getSessionId()));

				driver.get("https://github.com/SeleniumHQ");
				//Thread.sleep(5000); //Allow to open live view link
				Actions action = new Actions(driver);
				WebElement elem = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
	            action.moveToElement(elem).perform();
				//Thread.sleep(10000); //Allow to see
			}
			catch(Exception e) {
				System.out.println("moveToElement did not work.");
				System.out.println(e);
//            Raises following exception in case of firefox v52:
//            Caused by: org.openqa.selenium.UnsupportedCommandException: mouseMoveTo
//            Build info: version: '3.4.0', revision: 'unknown', time: 'unknown'
//            System info: host: '3ef0e26b9d0f', ip: '172.17.0.4', os.name: 'Linux', os.arch: 'amd64', os.version: '3.10.0-327.36.3.el7.x86_64', java.version: '1.8.0_111'
//            Driver info: driver.version: RemoteWebDriver
			}
			finally {
				driver.quit();
			}
		}


}
