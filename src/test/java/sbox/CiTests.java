/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static sbox.Settings.HUB;

public class CiTests {

    @Test
    public void ciDemo() throws IOException, InterruptedException {


        DesiredCapabilities capability = DesiredCapabilities.chrome();

        RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        driver.manage().window().maximize();


        driver.get("https://www.newyorkfed.org/");
        WebElement searchbox = driver.findElement(By.id("searchbox"));
        searchbox.clear();
        searchbox.sendKeys("interest rates");
        searchbox.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleIs("Search - FEDERAL RESERVE BANK of NEW YORK"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.newyorkfed.org/search?text=interest+rates&application=ny_pub&sources=ny_pub" );

        Thread.sleep(5000);
        driver.quit();
    }
}
