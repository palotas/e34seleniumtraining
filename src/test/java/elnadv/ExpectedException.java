/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by e34 on 13/10/2017.
 */
public class ExpectedException extends BaseTest {

    @Test(expectedExceptions = NoSuchElementException.class)
    public void checkThatElementNotOnPage() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://google.com");
            driver.findElement(By.id("abc")); //this element should not be on the page
        }
        finally {
            driver.quit();
        }

    }

    @Test
    public void checkThatElementNotOnPage2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://google.com");
            Assert.assertThrows(NoSuchElementException.class, ()->driver.findElement(By.id("abc")));
        }
        finally {
            driver.quit();
        }

    }

}
