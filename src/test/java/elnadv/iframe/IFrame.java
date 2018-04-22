/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.iframe;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrame extends BaseTest {

    @Test
    public void iFrame() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions act = new Actions(driver);

        try {
            driver.get("http://the-internet.herokuapp.com/iframe");
            driver.findElement(By.id("mceu_15-open")).click();
            Thread.sleep(5000);

            driver.findElement(By.id("tinymce")).sendKeys("Hello World");
            Thread.sleep(5000);


        }
        finally {
            driver.quit();
        }
    }



    @Test
    public void iFrameWithSwitch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions act = new Actions(driver);

        try {
            driver.get("http://the-internet.herokuapp.com/iframe");
            driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
            driver.findElement(By.id("tinymce")).sendKeys("Hello World");
            Thread.sleep(5000);


        }
        finally {
            driver.quit();
        }
    }
}
