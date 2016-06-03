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

	@DataProvider(name = "urlprovider", parallel=true)
	public Object[][] createData2() {
	 return new Object[][] {
	   {"1", "de", "Cloud Logistik Software für Transport Management"},
	   {"2", "en", "Cloud Logistics Software for Transportation Management"},
	   {"3", "fr", "TRANSPOREON - TMS Leader en Europe - La plateforme de communication logistique entre chargeurs et transporteurs"}
	 };
	}

	@Test(dataProvider="urlprovider")
	public void dataproviderTest(String testcaseId, String language, String expectedTitle) throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();
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

