package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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
}
