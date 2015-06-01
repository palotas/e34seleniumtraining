package remoteWebdriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class RemoteWebdriverTests {

	/*
	 * For these tests, the Selenium server needs to run 
	 */
	@Test
	public void remoteWebdriverFireFoxTest() throws IOException, InterruptedException {

		//create DesiredCapabilities object and set browser to Firefox
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("internet explorer");
				 
		/*
		 * create new RemoteWebdriver using the capabilities defined above
		 * navigate to URL http://gridfusion.net
		 * close browser
		 */
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		driver.get("http://gridfusion.net");
		Thread.sleep(1000);
		driver.quit();
		
	}

	

	

	/*
	 * same test as above just with Chrome browser
	 */
	@Test
	public void remoteWebdriverChromeTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	/*
	 * example for a remote test with IE
	 */
	@Test
	public void remoteWebdriverInternetExplorerTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("internet explorer");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
