package elnadv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzLoginPage {

    NzzHeaderSection headerSection;
    NzzLoginSection loginSection;

    public NzzLoginPage(WebDriver driver) {

        this.headerSection = new NzzHeaderSection(driver);
        this.loginSection = new NzzLoginSection(driver);
        driver.get("https://login.nzz.ch");
        PageFactory.initElements(driver, this);
    }


    public void enterUsername() {
        loginSection.enterLoginName("hello@world.ch");
        loginSection.enterLoginPass();
    }




}
