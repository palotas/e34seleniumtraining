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

public  class AxaDriverFactory {
	
	static String firefoxProfile = "selenium";
	static int proxy_type = 1;  //1=manual config, 2=pac file, 5=share system proxy settings
	
	/* AXA proxy settings */
	//static String proxy_http = "194.40.39.31";
	//static int http_port = 8080;
	
	/* local SQUID3 proxy settings */
	static String proxy_http = "localhost";
	static int http_port = 3128;
	
	
	static boolean share_proxy_settings = true; //--> needs to potentially be set to false!!!
	
		
public static WebDriver createAxaIEDriver() throws FileNotFoundException, IOException {
			
		//ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile ffprofile = profile.getProfile(firefoxProfile);
		//ffprofile.setPreference("signon.autologin.proxy", true);
		//ffprofile.setPreference("network.proxy.type", proxy_type); 
		//ffprofile.setPreference("network.proxy.http", proxy_http);
		//ffprofile.setPreference("network.proxy.http_port", http_port);
		//ffprofile.setPreference("network.proxy.share_proxy_settings", share_proxy_settings);
		
		//WebDriver driver = new FirefoxDriver(ffprofile);
	
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe"); //this sets the path to IE driver to seleniumtraining
		WebDriver driver = new InternetExplorerDriver();
	    return driver;
	}
	
	
	public static WebDriver createAxaRemoteIEDriver() throws FileNotFoundException, IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile ffprofile = profile.getProfile(firefoxProfile);
		//ffprofile.setPreference("signon.autologin.proxy", true);
		//ffprofile.setPreference("network.proxy.type", proxy_type); //1=manual config, 2=pac file
		//ffprofile.setPreference("network.proxy.http", proxy_http);
		//ffprofile.setPreference("network.proxy.http_port", http_port);
		//ffprofile.setPreference("network.proxy.share_proxy_settings", share_proxy_settings);
        
		//capabilities.setCapability(FirefoxDriver.PROFILE, ffprofile);
		capabilities.setBrowserName("internet explorer");
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe"); //this sets the path to IE driver to seleniumtraining

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	    return driver;
	}
}
