package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNGBrowserParameter {
	
	/*
	 * testng_browser_parameters.xml file is where the browsers are defined
	 */
	
	@Test
	@Parameters("browser")
	public void browserParameters(String browser) throws MalformedURLException {

		DesiredCapabilities capability =new DesiredCapabilities();
		
		if (browser.equals("FIREFOX")) {
			capability = DesiredCapabilities.firefox();
		}
		if (browser.equals("CHROME")) {
			capability = DesiredCapabilities.chrome();
		}
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");
		driver.quit();
	}
}
