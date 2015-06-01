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

	@Test
	public void myFirstTest() {

	    ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffprofile = profile.getProfile("selenium");

        ffprofile.setPreference("signon.autologin.proxy", true); 
        ffprofile.setPreference("network.proxy.type", 1); //1=manual config, 2=pac file
        //ffprofile.setPreference("network.proxy.http", "localhost");
        //ffprofile.setPreference("network.proxy.http_port", 3128); 
                
        WebDriver driver = new FirefoxDriver(ffprofile);
		
		// navigate to the URL 
		driver.get("http://gridfusion.net");

		// close the Browser
		driver.quit();
	}
	

	@Test
	public void axaProxyAuthTestWithDriverFactory() throws FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		
		// navigate to the URL 
		driver.get("http://gridfusion.net");
		// close the Browser
		driver.quit();
}


	@Test
	public void pageTitleTest() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		driver.get("http://gridfusion.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	@Test
	public void pageTitleTestWithAssertNoTryCatch() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		driver.get("http://gridfusion.net");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSION");
		driver.quit();
	}
	

	@Test
	public void pageTitleTestWithAssert() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		try {
			driver.get("http://gridfusion.net");
			Assert.assertEquals(driver.getTitle(), "ridfusion");			
		}
		finally {
			driver.quit();			
		}
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
}

