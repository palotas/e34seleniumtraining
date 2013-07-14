package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightSearchPageTest {
	
	@Test 
	public void flightSearchTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.kayak.com/flights");
				
		FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.selectRoundtrip();
		flightSearchPage.enterOrigin();
		flightSearchPage.enterDestination();
		flightSearchPage.enterDepartureDate();
		flightSearchPage.enterReturnDate();
		flightSearchPage.pressFindButton();
		
		Thread.sleep(10000);
		driver.quit();
	}
	
}


