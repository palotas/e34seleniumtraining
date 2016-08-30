package ebayPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyEbayPage {
	
	
	@FindBy(id="gh-ac")
	private WebElement searchBox;
	
	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	
	public MyEbayPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void enterItemNumber() {
		searchBox.sendKeys(EbayUtils.getItemid());
	}
	
	
	public ViewItemPage clickSearchBox(WebDriver driver) {
		searchButton.click();
		return new ViewItemPage(driver);
		
	}
	
	
	
}

