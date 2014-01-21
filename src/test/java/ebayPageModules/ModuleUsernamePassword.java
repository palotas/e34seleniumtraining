package ebayPageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebayFlows.UserObject;

public class ModuleUsernamePassword {
	
	private String uname;
	private String pass;
	
	@FindBy(id="userid")
	private WebElement userid;
	
	@FindBy(id="pass")
	private WebElement password;
	
	public ModuleUsernamePassword(WebDriver driver, UserObject user) {
		this.uname=user.getUserName();
		this.pass=user.getPassword();
	    PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		userid.clear();
		userid.sendKeys(uname);
		
	}
	
	public void enterPassword() {
		userid.clear();
		password.sendKeys(pass);		
	}

}
