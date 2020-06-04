/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomExpectedCondition {


    @BeforeTest
    public void setup() {
        String OS = System.getProperty("os.name");
        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/workspace/e34seleniumtraining/resources/linux/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/workspace/e34seleniumtraining/resources/linux/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            case "Windows 7":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\Downloads\\geckodriver");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\Downloads\\chromedriver.exe");
                break;

            case "Windows 10":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\micha\\IdeaProjects\\e34seleniumtraining\\resources\\windows\\chromedriver.exe");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }


    @Test
    public void customWaitTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.element34.io");

        Thread.sleep(3000);
        driver.findElement(By.id("calculateButton")).click();
        wait.until(calculationDone());
        driver.quit();
    }

    public static ExpectedCondition<Boolean> calculationDone() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return done === true");
            }
        };
    }
}
