package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTestNoPageObject {

    @Test
    public void loginTest() throws InterruptedException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(capabilities);

        NzzLoginPage loginPage = new NzzLoginPage(driver);

        WebElement login = driver.findElement(By.id("loginName"));
        login.sendKeys("testuser1@test.ch");

        WebElement password = driver.findElement(By.id("loginPass"));
        password.sendKeys("testpassword");

        driver.findElement(By.name("getSsoTicket")).click();


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
