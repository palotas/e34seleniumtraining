package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class CiscoLoginPage {

    WebDriver driver = null;

    @FindBy(id="userName")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="login-button")
    private WebElement button;


    public CiscoLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://eu2-dev.servicegrid.cisco-ccs.com/pages/sdcall/Login.jsp");
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public CiscoStartPage clickLogin() {
        button.click();
        return new CiscoStartPage(driver);
    }




}
