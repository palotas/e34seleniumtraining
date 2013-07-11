package util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public  class setupDriver {

	public static WebDriver setup(String url, String browser, String platform, String version) throws MalformedURLException {
		
		WebDriver driver; 
		DesiredCapabilities capabilities=new DesiredCapabilities();
             
		capabilities.setCapability("platform", platform);
	    capabilities.setCapability("browserName", browser);
	    capabilities.setCapability("version", version);

		driver = new RemoteWebDriver(new URL(url), capabilities);

	    return driver;
		
	}
}
