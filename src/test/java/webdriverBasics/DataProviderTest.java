package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name = "urlprovider")
	public Object[][] createData2() {
	 return new Object[][] {
	   {"1", "de", "Home | AXA Winterthur"},
	   {"2", "en", "Home | AXA Winterthur"},
	   {"3", "fr", "Home | AXA Winterthur"}
	 };
	}

	@Test(dataProvider="urlprovider")
	public void dataproviderTest(String testcaseId, String language, String expectedTitle) throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteFirefoxDriver();
		try{
			driver.get("https://www.axa-winterthur.ch/" + language);	
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), expectedTitle);	
		}
		finally{
			Thread.sleep(2000);
			driver.quit();	
		}	
	}
}

