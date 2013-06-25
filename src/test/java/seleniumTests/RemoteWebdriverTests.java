package seleniumTests;

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
	public void remoteWebdriverFireFoxTest() throws IOException {

		//create DesiredCapabilities object and set browser to Firefox
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		
	
		/*alternatively the browser can be set like this as well
		 *DesiredCapabilities capability = new DesiredCapabilities().firefox();
		 */
		 
		/*
		 * create new RemoteWebdriver using the capabilities defined above
		 * navigate to URL http://gridfusion.net
		 * close browser
		 */
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		driver.get("http://gridfusion.net");
		driver.quit();
		
	}

	
/*
 * this can be deleted
 
	@Test
	public void remoteWebdriverFireFoxTestWithScreenshot() throws IOException {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");

		  try {
		        WebDriver augmentedDriver = new Augmenter().augment(driver);
		        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(source, new File("/home/gridfusion/SeleniumTraining/screenshots/" + source.getName())); 

		        
				Reporter.log("<a href=" + "/home/gridfusion/SeleniumTraining/screenshots/" + source.getName() + " target='_blank' >" +  "</a>");

		  	}
		    catch(IOException e) {
		    	System.out.println(e.getMessage());
		    }

		driver.quit();
		
	}
*/
	
	

	/*
	 * same test as above just with Chrome browser
	 */
	@Test
	public void remoteWebdriverChromeTest() throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");
		driver.quit();
		
	}
	
	/*
	 * example for a remote test with IE
	 * if IE is not installed (like in this case) --> test fails
	 */
	@Test
	public void remoteWebdriverInternetExplorerTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost/4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
