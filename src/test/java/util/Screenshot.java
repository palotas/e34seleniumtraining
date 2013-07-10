package util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

public class Screenshot {
	
	
	public static void takeScreenshot(WebDriver driver) throws Exception {
			
	    //create augmented driver
	  	WebDriver augmentedDriver = new Augmenter().augment(driver);
	    //take screenshot
	  	File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	    //copy file to final destination
	  	FileUtils.copyFile(source, new File("file:///home/gridfusion/SeleniumTraining/screenshots/" + source.getName())); 

	    Reporter.log("Screenshot of page: " + "<b>" + driver.getTitle() + "</b>" + " at " + driver.getCurrentUrl());
	    Reporter.log("<br> <img src=/home/gridfusion/SeleniumTraining/screenshots/"+ source.getName() + " " + "width=\"320\" height=\"240\" /> <br>");

	}
	


}
