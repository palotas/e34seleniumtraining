package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSearchPage {
	
	private final WebDriver driver;
	
	@FindBy(id= "roundtrip-label")
	private WebElement roundtrip;

	@FindBy(id= "onewaytrip-label")
	private WebElement onewaytrip;
	
	@FindBy(id= "multi-label")
	private WebElement multicitytrip;
	
	@FindBy(id= "origin")
	private WebElement origin;

	@FindBy(id= "destination")
	private WebElement destination;
	
	@FindBy(id= "depart_date")
	private WebElement departureDate;
	
	@FindBy(id= "return_date")
	private WebElement returnDate;

	@FindBy(id= "fdimgbutton")
	private WebElement findButton;
	
	//constructor
	public FlightSearchPage(WebDriver driver){
		this.driver = driver;
		
		//if you comment this line out, you will get a nullpointer exception
		PageFactory.initElements(driver, this);

	}
	
	//actions on the base page
	public void selectRoundtrip() {
		roundtrip.click();
	}

	public void selectOnewayTrip() {
		onewaytrip.click();
	}
	
	public void selectMulticityTrip() {
		multicitytrip.click();
	}
	
	public void enterOrigin() {
		origin.clear();
		origin.sendKeys("ZRH");
	}
	
	public void enterDestination() {
		destination.clear();
		destination.sendKeys("JFK");
	}	
	
	public void enterDepartureDate() {
		departureDate.clear();
		departureDate.sendKeys("08/28/2013");
	}

	public void enterReturnDate() {
		returnDate.clear();
		returnDate.sendKeys("08/31/2013");
	}
	
	public void pressFindButton() {
		findButton.click();
	}
	
}

