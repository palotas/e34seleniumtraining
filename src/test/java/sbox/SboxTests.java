/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.util.Set;

import static elnadv.Helpers.sleepTight;
import static sbox.Helpers.getDownloadedFileName;
import static sbox.Helpers.getInternalSessionId;
import static sbox.Helpers.screenshot;
import static sbox.Settings.HUB;

public class SboxTests {


	@Test
	public void chromeHeadless() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		Dimension dimension = new Dimension(800, 600);

		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--headless");

		caps.setCapability(ChromeOptions.CAPABILITY, opts);
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), opts);
		driver.manage().window().setSize(dimension);
		driver.get("https://www.google.com");
		screenshot(driver);
		System.out.println(driver.getTitle());

		driver.quit();



	}

	@Test
	public void linkOpensInNewTab() throws IOException, InterruptedException {


		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.link.open_newwindow", 3);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("about:support");
		driver.getTitle();

		driver.quit();
	}


	@Test(invocationCount = 1, threadPoolSize = 50)
	public void maximize() throws IOException, InterruptedException {

//		FirefoxOptions options = new FirefoxOptions().addPreference("browser.link.open_newwindow", 3);
//		FirefoxDriver driver = new FirefoxDriver(options);

		FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("pdfjs.disabled", true);
		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
		//profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		//profile.setPreference("pdfjs.enabledCache.initialized", false);
		//profile.setPreference("pdfjs.migrationVersion", 2);
		//profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", true);
		//profile.setPreference("pdfjs.previousHandler.preferredAction", 4);

		profile.setPreference("pdfjs.enabledCache.state", false);

		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		options.addPreference("browser.link.open_newwindow", 3);


		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setCapability("video", true);
		capability.setCapability("e34_token", "a423174f");
		capability.setCapability("e34_per_test_timeout_ms", 600000);
		capability.setCapability("version", "59");
		capability.setCapability(FirefoxDriver.PROFILE, profile);
		capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

//		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://element34.com/testpage/");
		driver.getTitle();

		driver.quit();
	}



	@Test
	public void demo() throws IOException, InterruptedException {

		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setCapability("video", true);
		capability.setCapability("e34:token", "76ae8ff5-26a1-4c");
		capability.setCapability("e34_per_test_timeout_ms", 300000);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca8.element34.net/wd/hub"), capability);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.manage().window().maximize();

		printVideoURL(driver);

		driver.get("https://banking.westpac.com.au/wbc/banking/handler?TAM_OP=login&segment=personal&logout=false");
		driver.findElement(By.id("fakeusername")).sendKeys("hello");

		Thread.sleep(5000);
		driver.quit();
	}




	@Test(dataProvider = "browserProvider", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 10)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws IOException, InterruptedException {

		caps.setCapability("video", true);
		caps.setCapability("e34_token", "72aa4d82");
		caps.setCapability("e34_per_test_timeout_ms", 300000);
		caps.setCapability("e34:l_testName", caps.getBrowserName() + "  " + caps.getVersion());

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), caps);

		driver.get("https://www.westpac.com.au");
		printVideoURL(driver);
		Thread.sleep(5000);

		driver.quit();
	}

	@Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 10, threadPoolSize = 100)
	public void loadTest(String url) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("e34_token", "a423174f");
		capability.setCapability("e34:l_testName", "Selenium Test");
		capability.setCapability("version", "65");

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(driver.getTitle());
		Thread.sleep((long)(Math.random() * 20000));

		driver.quit();
	}





	@Test(dataProvider = "chromeVersions", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 100)
	public void chromeWithDifferentVersionsTest(String version) throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setCapability("e34_token", "50f70065");

		capability.setCapability("e34_per_test_timeout_ms", 300000);


		capability.setBrowserName("chrome");
		capability.setVersion(version);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		driver.manage().window().fullscreen();

		System.out.println("Browser version: " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

		driver.get("http://static.element34.net/e34");
		System.out.println("Video URL: " + HUB + "/videos/" + driver.getSessionId() + ".mp4");

		Thread.sleep(5000);
		driver.quit();
	}

	@Test(dataProvider = "tokens", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 100)
	public void testnames(String token) throws IOException, InterruptedException {


		DesiredCapabilities capability = DesiredCapabilities.chrome();
		//capability.setCapability("version", "56");
		capability.setCapability("video", true);
		capability.setCapability("e34_token", "c985c260");
		//capability.setCapability("e34_token",  token);
		capability.setCapability("e34:l_testName", "my test");
		//capab	ility.setCapability("e34_per_test_timeout_ms", 300000);
//		capability.setVersion("n-1");
		//capability.setCapability("l_testName", "SBOX Demo Test");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + ":443/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();
		printLiveViewURL(driver);
		printVideoURL(driver);

		driver.get("https://sbb.ch");

		Thread.sleep(20000);

		driver.quit();
	}


	@Test
	public void cisco() throws IOException, InterruptedException {

		FirefoxOptions opt = new FirefoxOptions();

		opt.addPreference("browser.link.open_newwindow", 3);
		DesiredCapabilities capability = DesiredCapabilities.firefox();

		capability.setCapability("moz:firefoxOptions", opt);
		capability.setCapability("video", true);
		capability.setCapability("e34_token", "50f70065");
		capability.setCapability("e34:l_testName", "Selenium Test" );


//		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca8.element34.net/wd/hub"), capability);
		driver.manage().window().maximize();

		printVideoURL(driver);

		System.out.println(driver.getCapabilities());
		driver.get("https://element34.com/testpage");
		driver.findElement(By.id("link")).click();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
			driver.switchTo().window(handle);
		}

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
		System.out.println("Video URL - " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion() + " : " + "https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");
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
