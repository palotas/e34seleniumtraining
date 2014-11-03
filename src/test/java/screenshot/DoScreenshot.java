package screenshot;

import io.selendroid.SelendroidDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class DoScreenshot {
		
	public static void takeScreenshotNoReport(WebDriver driver) throws Exception {
		
	  	RemoteWebDriver newDriver = (RemoteWebDriver)driver;
	    //take screenshot
	  	File source = ((TakesScreenshot)newDriver).getScreenshotAs(OutputType.FILE);
	    //copy file to final destination
	  	FileUtils.copyFile(source, new File("/home/gridfusion/SeleniumTraining/screenshots/" + source.getName())); 
	}

	public static void takeScreenshotWithReport(WebDriver driver) throws Exception {
		
	  	RemoteWebDriver newDriver = (RemoteWebDriver)driver;
	    //take screenshot
	  	File source = ((TakesScreenshot)newDriver).getScreenshotAs(OutputType.FILE);
	    //copy file to final destination
	  	FileUtils.copyFile(source, new File("/home/gridfusion/SeleniumTraining/screenshots/" + source.getName())); 

	    Reporter.log("Screenshot of page: " + "<b>" + driver.getTitle() + "</b>" + " at " + driver.getCurrentUrl());
	    Reporter.log("<br> <img src=/home/gridfusion/SeleniumTraining/screenshots/"+ source.getName() + " " + "width=\"320\" height=\"240\" /> <br>");

	}
	
	public static void remoteWebDriverScreenshot(WebDriver driver) throws IOException {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		 File screenshot = ((TakesScreenshot)augmentedDriver).
		 getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("/home/gridfusion/SeleniumTraining/screenshots/" + screenshot.getName()));
		    Reporter.log("Screenshot of page: " + "<b>" + driver.getTitle() + "</b>" + " at " + driver.getCurrentUrl());
		    Reporter.log("<br> <img src=/home/gridfusion/SeleniumTraining/screenshots/"+ screenshot.getName() + " " + "width=\"320\" height=\"240\" /> <br>");
	}
	
	
}
