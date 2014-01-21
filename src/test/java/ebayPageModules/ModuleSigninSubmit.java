package ebayPageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModuleSigninSubmit {

	@FindBy(id="sgnBt")
	private WebElement signinButton;
	
	public ModuleSigninSubmit(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void clickSubmitButton() {
		signinButton.click();
	}
}
