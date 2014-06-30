package ebayTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ebayPageObjects.SigninPage;

public class SigninPageObjectTests {
	
    @Test
    public void signinWithPageObjectSingle() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        SigninPage signinpage = new SigninPage(driver);

        signinpage.enterUsername();
        signinpage.enterPassword();
        signinpage.clickSigninButton();

        Thread.sleep(5000);
        driver.quit();

    }

}


