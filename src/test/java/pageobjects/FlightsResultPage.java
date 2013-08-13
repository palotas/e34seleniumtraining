package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsResultPage {
	
	@FindBy(id= "inlineorigin")
	private WebElement origin;

	@FindBy(id= "inlinedestination")
	private WebElement destination;

	@FindBy(id= "inline_depart_date")
	private WebElement departdate;
	
	@FindBy(id= "inline_return_date")
	private WebElement returndate;
	
	@FindBy(className= "ui-button")
	private WebElement submit;
	
	
	private final WebDriver driver;
	private WebDriverWait wait;


	public FlightsResultPage(WebDriver d) {
		this.driver = d;
		this.wait=new WebDriverWait(d, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void enterOrigin() {
		
		//wait.until(ExpectedConditions.visibilityOf(origin));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		origin.clear();
		origin.sendKeys("FRA");
	}
	
	public void enterDestination() {
		destination.clear();
		destination.sendKeys("TXL");
	}
	
	public void enterDepartDate() {
		departdate.clear();
		departdate.sendKeys("12/11/2013");
	}
	
	public void enterReturnDate() {
		returndate.clear();
		returndate.sendKeys("12/24/2013");
	}	
	
	public void pressSubmit() {
		submit.click();
	}

}
