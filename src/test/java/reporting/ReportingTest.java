package reporting;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import screenshot.DoScreenshot;


public class ReportingTest {

	@Test
	public void simpleReportingTest() {
		
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);	
	}
	
	
	@Test
	public void reportingTestWithMessage() {
		Reporter.log("starting the test");
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);
		Reporter.log("This is some " + "<b>bold</b> " + "and " + "<i>italic</i>" + " text");
		Reporter.log("ending the test");
	}
	
	
	@Test(enabled=true)
	public void fireFoxTestWithScreenshotReport() throws Exception {
		
		Reporter.log("<h1>Creating driver</h1>");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://gridfusion.net");

		  try {
		       DoScreenshot.takeScreenshotWithReport(driver);

		  	}
		    catch(IOException e) {
		    	System.out.println(e.getMessage());
		    }
		  
		  finally {
				driver.quit();			  
		  }
	}
	
	
	/*
	 * take screenshot with augmented driver
	 * insert screenshot into report
	 */
	/*
	@Test(enabled=true)
	public void fireFoxTestWithScreenshotReport() throws IOException {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://gridfusion.net");

		  try {
		        //create augmented driver
			  	WebDriver augmentedDriver = new Augmenter().augment(driver);
		        //take screenshot
			  	File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		        //copy file to final destination
			  	FileUtils.copyFile(source, new File("/home/gridfusion/SeleniumTraining/screenshots/" + source.getName())); 

		        Reporter.log("Screenshot of page: " + "<b>" + driver.getTitle() + "</b>");
		        Reporter.log("<br> <img src=/home/gridfusion/SeleniumTraining/screenshots/"+ source.getName() + " /> <br>");


		  	}
		    catch(IOException e) {
		    	System.out.println(e.getMessage());
		    }
		  
		  finally {
				driver.quit();			  
		  }
	}
	*/
	

}
