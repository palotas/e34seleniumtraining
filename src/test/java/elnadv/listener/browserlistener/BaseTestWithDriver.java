/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.listener.browserlistener;

import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestWithDriver extends BaseTest {

    private WebDriver driver;

    public WebDriver webdriver() {
        return driver;
    }

    @BeforeMethod
    public void createDriver() {
        this.driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }

        }
    }
}