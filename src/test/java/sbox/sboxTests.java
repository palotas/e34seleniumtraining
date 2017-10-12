package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class sboxTests {

	private final String host = "192.168.1.178";

	//@BeforeTest
	//public void setup() {
	//	Settings.setHubUrl("https://vm-106.element34.net");
	//}

	//runs Chrome in version LATEST and LATEST-x
	@DataProvider(name = "chromeVersions", parallel = true)
	public Object[][] createData1() {
		return new Object[][] {
				{""},
				{"n-1"},
				{"n-2"},
				{"n-3"}
		};
	}

	//browsers and versions are hardcoded on the data provider
	@DataProvider(name = "browserProvider", parallel = true)
	public Object[][] getDrivers() {

		DesiredCapabilities chrome1 = DesiredCapabilities.chrome();
		chrome1.setCapability("version", "58");

		DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
		chrome2.setCapability("version", "57");

		DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
		chrome3.setCapability("version", "56");

		DesiredCapabilities internetExplorer = DesiredCapabilities.internetExplorer();

		DesiredCapabilities edge = DesiredCapabilities.edge();


		return new Object[][]{
				{chrome1},
				{chrome2},
				{chrome3},
				{internetExplorer},
				{edge},
    	};
	}


	//no hardcoded versions. Sliding window depending on what is configured on SBOX as LATEST
	@DataProvider(name = "browserProviderWithoutVersions", parallel = true)
	public Object[][] getDriversWithoutVersion() {

		//if no version is set, then latest browser version is used
		DesiredCapabilities firefox1 = DesiredCapabilities.firefox();

		//use n-1, n-1 etc. to specify non-hardcoded browserversions (sliding window)
		DesiredCapabilities firefox2 = DesiredCapabilities.firefox();
		firefox1.setCapability("version", "n-1");

		DesiredCapabilities firefox3 = DesiredCapabilities.firefox();
		firefox1.setCapability("version", "n-2");

		DesiredCapabilities chrome1 = DesiredCapabilities.chrome();

		DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
		chrome2.setCapability("version", "n-1");

		DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
		chrome3.setCapability("version", "n-2");

		return new Object[][]{
				{firefox1},
				{firefox2},
				{firefox3},
				{chrome1},
				{chrome2},
				{chrome3},
		};
	}



	@Test(dataProvider = "chromeVersions", invocationCount = 1)
	public void chromeWithDifferentVersionsTest(String version) throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		capability.setVersion(version);

		//replace URL with company specific entry point
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca8.element34.net:443/wd/hub"), capability);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net:443/wd/hub"), capability);

		System.out.println("Browser version: " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

		//replace with company specific URL
		driver.get("http://www.google.com");
		System.out.println("Video URL: " + "https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");

		//leave browser open for 5 seconds and close browser afterwards
		Thread.sleep(5000);
		driver.quit();
	}

	@Test(dataProvider = "browserProvider", invocationCount = 1)
	public void multiBrowserVersionTest(DesiredCapabilities caps) throws IOException, InterruptedException {

		//enable video recording
		caps.setCapability("video", true);

		//replace URL with company specific entry point
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net:443/wd/hub"), caps);
		System.out.println("Live View URL > http://vm-105.element34.net:4444/ui/liveview?session=" + driver.getSessionId().toString());


		//replace with company specific URL
		driver.get("http://www.westpac.com.au");
		System.out.println("Video URL - " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion() + " : " + "https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");

		//leave browser open for 5 seconds and close browser afterwards
		Thread.sleep(5000);
		driver.quit();
	}


	@Test(invocationCount = 1, threadPoolSize = 5)
	public void singleTest() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		capability.setCapability("l_testName", "test12345");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net:443/wd/hub"), capability);
		printLiveViewURL(driver);
		printVideoURL(driver);

		driver.get("https://stackoverflow.com/questions/27241186/how-to-determine-when-document-has-loaded-after-loading-external-css");


		for(int i= 0; i < 300; i++){
			driver.getTitle();
			driver.getCurrentUrl();
			driver.get("https://google.com");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println(js.executeScript("return document.readyState"));
			//System.out.println(js.executeScript("return jQuery.active"));
			Thread.sleep(250);
			driver.get("https://stackoverflow.com/questions/27241186/how-to-determine-when-document-has-loaded-after-loading-external-css");

		}


		driver.quit();
	}



	@Test
	public void fileDownload() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("video", true);
		capability.setBrowserName("chrome");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net:443/wd/hub"), capability);

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		System.out.println("Session ID: " + driver.getSessionId());
		printVideoURL(driver);
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


/*
	@WebTest(video = true, browsers = Browsers.TIER1)
	@Test
	public void sboxTest() throws IOException, InterruptedException {


		for(int i=0 ; i < 10 ; i++ )
		{
			webdriver().get("http://www.google.com");
			screenshot("let's take a screenshot");
			System.out.println(webdriver().getTitle());
			Thread.sleep(2000);
		}

		webdriver().quit();
	}
*/

	private void printVideoURL(RemoteWebDriver driver) {
		System.out.println("Video URL - " + driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion() + " : " + "https://vm-106.element34.net/videos/" + driver.getSessionId() + ".mp4");
	}

	private void printLiveViewURL(RemoteWebDriver driver) {
		System.out.println("Live View URL > http://vm-106.element34.net:4444/ui/liveview?session=" + driver.getSessionId().toString());
	}


	@Test
	public void ciscoTest() {
			RemoteWebDriver driver = null;
			String version = "47";
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("browserName", "chrome");
			//dc.setCapability("version", "49");
			//dc.setCapability("auth","token");
			dc.setCapability("video", true);
			try {
				//driver = new RemoteWebDriver(new URL("http://seleniumbox.cisco.com/wd/hub"), dc);
				driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), dc);
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
