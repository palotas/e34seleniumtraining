/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.brokenimages;

import elnadv.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class contextmenu extends BaseTest {

    @Test
    public void hover() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
            WebElement hotspot = driver.findElement(By.cssSelector("body > div > section > div > div > div > p > span"));

            Actions action= new Actions(driver);
            action.contextClick(hotspot).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

            Thread.sleep(3000);

        }
        finally {
            driver.quit();
        }
    }
}
