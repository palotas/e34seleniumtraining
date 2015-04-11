package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name = "nameprovider")
	public Object[][] createData2() {
	 return new Object[][] {
	   {"1", "Michael", "Palotas", "13"},
	   {"2", "Lori", "Palotas", "11"},
	   {"3", "Alex", "Palotas", "11"}
	 };
	}

	@Test(dataProvider="nameprovider")
	public void dataproviderTest(String testcaseId, String first, String last, CharSequence length) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		try{
			driver.get("http://localhost:8080/tmf2/");
			WebElement firstName=driver.findElement(By.id("firstname"));
			WebElement lastName=driver.findElement(By.id("lastname"));
			WebElement submitButton=driver.findElement(By.id("submitbutton"));

			firstName.sendKeys(first);
			lastName.sendKeys(last);
			submitButton.click();
			
			Assert.assertTrue(driver.getPageSource().contains(length));	
		}
		finally{
			Thread.sleep(2000);
			driver.quit();	
		}	
	}
}

