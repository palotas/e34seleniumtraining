package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFlightSearchTest {
	
	@Test 
	public void flightSearch() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.kayak.com/flights");
		
		Assert.assertEquals(driver.getTitle(), "KAYAK - Cheap Flights - Deals on Airline Tickets - Airfare - Compare Hundreds of Travel Sites");

		WebElement tab=driver.findElement(By.id("roundtrip-label"));
		tab.click();
		
		WebElement origin=driver.findElement(By.id("origin"));
		origin.sendKeys("ZRH");
		
		WebElement destination=driver.findElement(By.id("destination"));
		destination.sendKeys("JFK");
	
		WebElement departDate=driver.findElement(By.id("depart_date"));
		departDate.clear();
		departDate.sendKeys("08/28/2013");

		WebElement returnDate=driver.findElement(By.id("return_date"));
		returnDate.clear();
		returnDate.sendKeys("08/31/2013");

		WebElement searchButton=driver.findElement(By.id("fdimgbutton"));
		searchButton.click();
		
		Thread.sleep(10000);

		driver.quit();

	}

}
