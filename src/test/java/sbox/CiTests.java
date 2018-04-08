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
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static sbox.Settings.HUB;

public class CiTests {

    @Test
    public void ciDemo() throws IOException, InterruptedException {


        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability("video", true);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), capability);
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        Reporter.log("<a href=" + printVideoURL(driver) + ">Click here for a video of this test</a>");

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

    @Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 5, threadPoolSize = 100)
    public void loadTest(String url) throws IOException, InterruptedException {


        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability("version", "65");

        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), capability);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println(driver.getTitle());
        Thread.sleep((long)(Math.random() * 20000));

        driver.quit();
    }

    private String printVideoURL(RemoteWebDriver driver) {
        return ("https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");
    }
}
