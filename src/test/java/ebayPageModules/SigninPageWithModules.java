package ebayPageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebayFlows.UserObject;

public class SigninPageWithModules {
	
	WebDriver driver;
	UserObject user;
	ModuleUsernamePassword moduleUsernamePassword;
	ModuleSigninSubmit moduleSigninSubmit;
	
	@FindBy(id="sgnBt")
	WebElement signinButton;
	
	
	public SigninPageWithModules(WebDriver driver, UserObject user) {
		this.moduleSigninSubmit=new ModuleSigninSubmit(driver);
		this.moduleUsernamePassword=new ModuleUsernamePassword(driver, user);
	    PageFactory.initElements(driver, this);

	}
	
	public void clickSigninButton() {
		signinButton.click();
	}
	
	

}
