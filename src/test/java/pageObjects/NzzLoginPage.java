package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzLoginPage {

    @FindBy(id="loginName")
    private WebElement loginName;

    @FindBy(id="loginPass")
    private WebElement loginPass;

    @FindBy(name="getSsoTicket")
    private WebElement button;


    public NzzLoginPage(WebDriver driver) {
        driver.get("https://login.nzz.ch/");
        PageFactory.initElements(driver, this);
    }

    public void enterLoginName() {
        loginName.sendKeys("testuser@test.ch");
    }

    public void enterLoginPass() {
        loginPass.sendKeys("testpassword");
    }

    public void clickAnmeldenButton() {
        button.click();
    }

    public void login() {
        enterLoginName();
        enterLoginPass();
        clickAnmeldenButton();
    }


}
