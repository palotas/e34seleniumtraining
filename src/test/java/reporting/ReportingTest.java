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
	
}
