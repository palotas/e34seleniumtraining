/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Helpers {


    public static boolean isElementPresent(WebDriver driver, By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + by.toString());
            return false;
        }
    }


    public static void sleepTight(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].style.border='2px solid red'", element);
    }

}
