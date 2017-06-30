package InterfacePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 20/09/15.
 */
public class LoginTest {

    @Test
    public void loginTest1() {

        WebDriver driver = new FirefoxDriver();
        LoginPage1 mypage = new LoginPage1(driver);

        mypage.enterUserName("gridfusion");
        mypage.enterPassword("");
        mypage.clickLoginButton();
    }

    @Test
    public void loginTest2() {

        WebDriver driver = new FirefoxDriver();
        LoginPage2 mypage = new LoginPage2(driver);

        mypage.enterUserName("gridfusion");
        mypage.enterPassword("");
        mypage.clickLoginButton();
    }


}
