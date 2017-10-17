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
