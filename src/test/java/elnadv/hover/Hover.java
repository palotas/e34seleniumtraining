/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.hover;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static elnadv.Helpers.sleepTight;

public class Hover extends BaseTest {

    @Test
    public void hover() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions act = new Actions(driver);

        try {
            driver.get("http://the-internet.herokuapp.com/hovers");
            act.moveToElement(driver.findElement(By.cssSelector("#content > div > div:nth-child(3)"))).build().perform();
            Thread.sleep(3000);

            act.moveToElement(driver.findElement(By.cssSelector("#content > div > div:nth-child(4)"))).build().perform();

            Thread.sleep(5000);

        }
        finally {
            driver.quit();
        }
    }
}
