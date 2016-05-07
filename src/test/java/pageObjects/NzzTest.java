package pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTest {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        NzzLoginPage loginPage = new NzzLoginPage(driver);

        loginPage.enterLoginName();
        loginPage.enterLoginPass();
        loginPage.clickAnmeldenButton();

        Assert.assertTrue(isElementPresent(driver, "message-password-mismatch"));

        driver.quit();

    }

    public boolean isElementPresent(WebDriver driver, String className) {
        return driver.findElements(By.className(className)).size() != 0;
    }

}
