/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTest {

    @BeforeTest
    public void setup() {
        String OS = System.getProperty("os.name");

        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }

    @Test
    public void loginTest() throws InterruptedException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        NzzLoginPage loginPage = new NzzLoginPage(driver);

        loginPage.enterLoginName("helga@cisco.com");
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
