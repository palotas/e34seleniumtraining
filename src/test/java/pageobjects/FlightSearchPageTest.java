package pageobjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class FlightSearchPageTest {
	
	
    @DataProvider (name="FlightDataProvider")     
    public static Iterator<Object[]> createData(){ 
            List<Object[]> myEntries = new ArrayList<Object[]>(); 
            try { 
                    CSVReader reader = new CSVReader(new FileReader("/home/gridfusion/SeleniumTraining/Workspace/selenium/src/test/java/util/flightdata.csv")); 
                    String[] nextLine = null; 
                    while ((nextLine = reader.readNext()) != null){ 
                            myEntries.add(new Object [] {nextLine}); 
                    } 
            } 
            catch (FileNotFoundException e) { 
                    e.printStackTrace(); 
            } catch (IOException e) { 
                    e.printStackTrace(); 
            } 
            
            return myEntries.iterator(); 
    }   
    
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
		
		FlightsResultPage flightsResultPage=flightSearchPage.pressFindButton();
		
		//Thread.sleep(3000);
		
		flightsResultPage.enterOrigin();
		flightsResultPage.enterDestination();
		flightsResultPage.enterDepartDate();
		flightsResultPage.enterReturnDate();
		flightsResultPage.pressSubmit();
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}
	
	
	@Test(dataProvider="FlightDataProvider")
	public void flightSearchTestWithDataProvider(String[] line) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.kayak.com/flights");
				
		FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.selectRoundtrip();
		flightSearchPage.enterOriginDataProvider(line[0]);
		flightSearchPage.enterDestination();
		flightSearchPage.enterDepartureDate();
		flightSearchPage.enterReturnDate();
		
		FlightsResultPage flightsResultPage=flightSearchPage.pressFindButton();
		
		//Thread.sleep(3000);
		
		flightsResultPage.enterOrigin();
		flightsResultPage.enterDestination();
		flightsResultPage.enterDepartDate();
		flightsResultPage.enterReturnDate();
		flightsResultPage.pressSubmit();
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}
	
}


