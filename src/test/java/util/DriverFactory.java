package util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public  class DriverFactory {

	
	/* local SQUID3 proxy settings */
	static String proxy_http = "localhost";
	static int http_port = 3128;
	
	
	static boolean share_proxy_settings = true; //--> needs to potentially be set to false!!!



	//remote FF driver
	public static WebDriver createRemoteFirefoxDriver() throws FileNotFoundException, IOException {

		System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	    return driver;
	}

	//remote IE driver
	public static WebDriver createRemoteIEDriver() throws FileNotFoundException, IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("internet explorer");
		//System.setProperty("webdriver.ie.driver", "IEDriverServer.exe"); //not needed if server is started with same options via command line

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	    return driver;
	}
	


}
