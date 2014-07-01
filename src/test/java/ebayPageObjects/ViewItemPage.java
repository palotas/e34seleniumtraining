package ebayPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ViewItemPage {
	
	
	@FindBy(className="vi-atw-txt")
	private WebElement addToWatchListButton;
	
	@FindBy(id="msgPanel")
	private WebElement msgPanel;
	

	public ViewItemPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	
	public void clickWatchListButton() {
		addToWatchListButton.click();
	}
	
	
	public String getMessagePanelText() {
		return msgPanel.getText();
	}
}

