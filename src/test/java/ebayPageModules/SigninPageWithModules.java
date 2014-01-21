package ebayPageModules;

import org.openqa.selenium.WebDriver;

import ebayFlows.UserObject;

public class SigninPageWithModules {
	
	WebDriver driver;
	UserObject user;
	ModuleUsernamePassword moduleUsernamePassword;
	ModuleSigninSubmit moduleSigninSubmit;
	
	
	public SigninPageWithModules(WebDriver driver, UserObject user) {
		this.moduleSigninSubmit=new ModuleSigninSubmit(driver);
		this.moduleUsernamePassword=new ModuleUsernamePassword(driver, user);
	}
	
	

}
