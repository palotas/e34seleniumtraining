/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderTest {

	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");

		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}

	@DataProvider(name = "urlprovider", parallel=true)
	public Object[][] createData2() {
	 return new Object[][] {
	   {"1", "de", "Cloud Logistik Software für Transport Management"},
	   {"2", "en", "Cloud Logistics Software for Transportation Management"},
	   {"3", "fr", "TRANSPOREON - TMS Leader en Europe - La plateforme de communication logistique entre chargeurs et transporteurs"}
	 };
	}

	@Test(dataProvider="urlprovider")
	public void dataproviderTest(String testcaseId, String language, String expectedTitle) throws InterruptedException, IOException {

		WebDriver driver = new FirefoxDriver();
		try{
			driver.get("https://www.transporeon.com/" + language);
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), expectedTitle);	
		}
		finally{
			Thread.sleep(2000);
			driver.quit();	
		}	
	}
}

