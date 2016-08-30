package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTest {

    @Test
    public void loginTest() throws InterruptedException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(capabilities);

        NzzLoginPage loginPage = new NzzLoginPage(driver);

        loginPage.enterLoginName();
        loginPage.enterLoginPass();
        loginPage.clickAnmeldenButton();

        //Assert.assertTrue(isElementPresent(driver, "message-password-mismatch"));
        Assert.assertTrue(isElementPresent(driver, By.className("message-password-mismatch")));

        driver.quit();

    }

    public boolean isElementPresent(WebDriver driver, String className) {
        return driver.findElements(By.className(className)).size() != 0;
    }

    public boolean isElementPresent(WebDriver driver, By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
