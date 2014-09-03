package postauto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	
	@FindBy(id="edit-name")
	private WebElement username;
	
	@FindBy(id="edit-pass")
	private WebElement password;
	
	@FindBy(id="edit-submit")
	private WebElement loginButton;	
	
	
	
	public SigninPage(WebDriver driver) {
		//driver.get("https://signin.ebay.de/ws/eBayISAPI.dll?SignIn");
	    PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		username.sendKeys("admin");
	}
	
	public void enterPassword() {
		password.sendKeys("admin");
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	
	
}

