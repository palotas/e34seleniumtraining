package InterfacePageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by gridfusion on 20/09/15.
 */
public class LoginPage2 extends LoginPageBase implements LoginPageInterface {


    public LoginPage2(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUserName(String username) {

        userid.sendKeys("hello world");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userid.clear();
        userid.sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {

        pass.clear();
        pass.sendKeys(password);

    }

    @Override
    public void clickLoginButton() {

        signinButton.click();
    }
}
