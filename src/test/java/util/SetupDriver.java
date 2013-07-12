package util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public  class SetupDriver {
	
		
	
	public static WebDriver setup() throws FileNotFoundException, IOException {
		
		WebDriver driver; 
		DesiredCapabilities capabilities=new DesiredCapabilities();
        
		Properties p=util.PropertyUtil.readProperties();
		String gridurl=p.getProperty("gridurl");
		
		capabilities.setCapability("platform", p.getProperty("platform"));
	    capabilities.setCapability("browserName", p.getProperty("browser"));
	    capabilities.setCapability("version", p.getProperty("version"));

        driver = new RemoteWebDriver(new URL(gridurl), capabilities);

	    return driver;
		
	}
}
