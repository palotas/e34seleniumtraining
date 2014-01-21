package ebayPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebayFlows.UserObject;

public class RegistrationPage {
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;	

	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="PASSWORD")
	private WebElement password;
	
	@FindBy(id="rpass")
	private WebElement repeatpassword;
	
	@FindBy(id="acceptq1")
	private WebElement acceptCheckbox;	
	
	@FindBy(id="sbtBtn")
	private WebElement submitButton;

	private String first;	
	private String last;
	private String userEmail;
	private String userPassword;
	private String repeatPassword;
	private Boolean acceptButton;
	
	WebDriver driver;
	
	
	public RegistrationPage(UserObject user, WebDriver driver) {

		first=user.getFirstName();
		last=user.getLastName();
		userEmail=user.getEmail();
		userPassword=user.getPassword();
		repeatPassword=user.getRepeatPassword();
		
	    PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void openPage() {
		driver.get("https://scgi.ebay.de/ws/eBayISAPI.dll?RegisterEnterInfo");
	}
	

	public void fillFirstName() {
		firstName.clear();
		firstName.sendKeys(first);
	}

	public void fillLastName() {
		lastName.clear();
		lastName.sendKeys(last);
	}
	
	public void fillEmail() {
		email.clear();
		email.sendKeys(userEmail);
	}

	public void fillPassword() {
		password.clear();
		password.sendKeys(userPassword);
	}

	public void fillRepeatPassword() {
		repeatpassword.clear();
		repeatpassword.sendKeys(repeatPassword);
	}
	
	public void tickAcceptCheckbox() {
		acceptCheckbox.click();
	}	

	public void submitPage() {
		submitButton.click();
	}
	
	public boolean dupMessageExists() {		
		try{
			driver.findElement(By.id("email_w"));			
		}
		catch (Exception e){
			return false;
		}

		return true;
	}
}
