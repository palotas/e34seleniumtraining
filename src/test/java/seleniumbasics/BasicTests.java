/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BasicTests {

	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/workspace/e34seleniumtraining/resources/linux/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/workspace/e34seleniumtraining/resources/linux/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			case "Windows 7":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\Downloads\\geckodriver");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\Downloads\\chromedriver.exe");
				break;

			case "Windows 10":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\x051717\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\x051717\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}
	


	@Test
	public void firstChromeTest() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.element34.com");

		driver.quit();
	}

}

