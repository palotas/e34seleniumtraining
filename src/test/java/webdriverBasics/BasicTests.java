package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests {

	/*
	 * This test: - creates a new Firefox Driver / open a Firefox Browser -
	 * opens the page http://gridfusion.net - closes the browser
	 * 
	 * Please note: no actual verification of anything is done
	 * 
	 * If you install from scratch: make sure to put selenium jar into classpath
	 * test runs with local firefox driver selenium server jar does not need to
	 * run for this
	 */

	@Test
	public void axaProxyAuthTestWithDriverFactory() throws FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteFirefoxDriver();

		// navigate to the URL 
		driver.get("http://www.axa.ch");
		// close the Browser
		//driver.quit();
}
	
	@Test
	public void axaProxyAuthTest() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("selenium");
		ffprofile.setPreference("signon.autologin.proxy", true);
		ffprofile.setPreference("network.proxy.type", 1); //1=manual config, 2=pac file
		ffprofile.setPreference("network.proxy.http", "194.40.39.31");
		ffprofile.setPreference("network.proxy.http_port", 8080);
		//ffprofile.setPreference("network.proxy.share_proxy_settings", true);
		WebDriver driver = new FirefoxDriver(ffprofile);

		// navigate to the URL 
		driver.get("http://gridfusion.net");
		// close the Browser
		//driver.quit();
}
	
	
	@Test
	public void myFirstTest() {

	    ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffprofile = profile.getProfile("proxyauth");

        ffprofile.setPreference("signon.autologin.proxy", true); 
        ffprofile.setPreference("network.proxy.type", 1); //1=manual config, 2=pac file
        //ffprofile.setPreference("network.proxy.http", "localhost");
        //ffprofile.setPreference("network.proxy.http_port", 3128); 
                
        WebDriver driver = new FirefoxDriver(ffprofile);
        
		// create the driver and open Firefox
		//WebDriver driver = new FirefoxDriver();
		
		// navigate to the URL 
		driver.get("http://gridfusion.net");

		// close the Browser
		driver.quit();
	}

	/*
	 * This test: - creates Firefox Driver / opens a Firefox browser - navigates
	 * to http://gridfusion.net - gets the page title - prints out the page
	 * title - closes the browser - note: test will always pass, as no asserts
	 * are done
	 */
	@Test
	public void pageTitleTest() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	@Test
	public void pageTitleTestWithAssertNoTryCatch() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net");
		Assert.assertEquals(driver.getTitle(), "Gridfusion-Technology & Management Consulting");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get("http://gridfusion.net");
			Assert.assertEquals(driver.getTitle(), "ridfusion-Technology & Management Consulting");			
		}
		finally {
			driver.quit();			
		}
	}
}

