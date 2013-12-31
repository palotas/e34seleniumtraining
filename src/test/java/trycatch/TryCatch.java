package trycatch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryCatch {
	
	
	@Test
	public void pageTitleTestFailNoTryCatch() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.abraxas.ch");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");	
		driver.quit();
	}	
	
	
	
	
	/*
	 * upon assertion failure the test stops
	 * and the browser is not closed
	 * add try/catch/finally to fix this
	 */
	@Test
	public void pageTitleTestFailWithTryCatch() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get("http://www.abraxas.ch");
			Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");	
		}
		catch (Error e) {
			System.out.println("Error message: " + e.getMessage());
			/*
			 * note: the test passes because we caught the exception
			 * to make it fail add: Assert.fail();
			 */
			Assert.fail();
		}
		finally {
			driver.quit();
		}
	}

}
