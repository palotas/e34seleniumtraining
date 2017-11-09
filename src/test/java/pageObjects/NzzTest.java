/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package pageObjects;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        NzzLoginPage loginPage = new NzzLoginPage(driver);
        loginPage.loadPage(driver);

        loginPage.enterLoginName("me@myself.com");
        loginPage.enterLoginPass();
        loginPage.clickRememberMe();
        Thread.sleep(5000);
        loginPage.clickAnmeldenButton();

        //Assert.assertTrue(isElementPresent(driver, By.className("message-password-mismatch")));

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
