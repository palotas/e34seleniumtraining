/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.brokenimages;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrokenImages extends BaseTest {

    @Test
    public void hover() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        JavascriptExecutor jse = (JavascriptExecutor)driver;


        try {
            driver.get("http://the-internet.herokuapp.com/broken_images");
            List<WebElement> images = driver.findElements(By.tagName("img"));
            List<WebElement> broken = new ArrayList<>();

            for (WebElement image:images) {
                jse.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
                broken.add(image);
            }

            Thread.sleep(5000);
            System.out.println(broken.size());

        }
        finally {
            driver.quit();
        }
    }
}
