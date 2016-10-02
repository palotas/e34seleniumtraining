package ebayFlows;

import org.openqa.selenium.WebDriver;

import ebayPageObjects.RegistrationPage;

public class RegistrationFlow {
	
	WebDriver driver;
	
	public RegistrationFlow(WebDriver driver) {
		this.driver=driver;
	}
		
	public void fillInUserInformation(UserObject user, WebDriver driver) {
		
		RegistrationPage regPage = new RegistrationPage(user, driver);
		regPage.openPage();
		regPage.fillFirstName();
		regPage.fillLastName();
		regPage.fillEmail();
		regPage.fillPassword();
		regPage.fillRepeatPassword();
		
		regPage.tickAcceptCheckbox();
		//regPage.submitPage();
	}

}
