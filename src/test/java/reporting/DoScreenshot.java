package reporting;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class DoScreenshot {


	final static String path = "/home/e34/workspace/seleniumtraining/screenshots/";

	
	public static void remoteWebDriverScreenshot(RemoteWebDriver driver) throws IOException {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		 File screenshot = ((TakesScreenshot)augmentedDriver).
		 getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File(path + screenshot.getName()));
		 System.out.println(screenshot.getName());
	}

}
