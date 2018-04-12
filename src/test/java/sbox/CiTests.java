/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import elnadv.listener.browserlistener.BaseTestWithDriver;
import elnadv.listener.browserlistener.StatusListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static sbox.Settings.HUB;

@Listeners(StatusListenerSbox.class)
public class CiTests extends TestBaseThreadSafe {

//    @Test
//    public void ciDemo() throws IOException, InterruptedException {
//
//
//        WebDriver driver = getDriver();
//        WebDriverWait wait =  new WebDriverWait(driver, 10);
//        driver.manage().window().maximize();
//
//        try {
//            driver.get("https://www.newyorkfed.org/");
//            WebElement searchbox = driver.findElement(By.id("searchbox"));
//            searchbox.clear();
//            searchbox.sendKeys("interest rates");
//            searchbox.sendKeys(Keys.ENTER);
//
//            wait.until(ExpectedConditions.titleIs("Search - FEDERAL RESERVE BANK of NEW YORK"));
//            Assert.assertEquals(driver.getCurrentUrl(), "https://www.newyorkfed.org/search?text=interest+rates&application=ny_pub&sources=ny_pub" );
//        }
//        finally {
//            logVideoUrl((RemoteWebDriver) driver);
//            Thread.sleep(5000);
//            driver.quit();
//        }
//
//
//    }
//
//    @Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 5, threadPoolSize = 100)
//    public void loadTest(String url) throws IOException, InterruptedException {
//
//
//        DesiredCapabilities capability = DesiredCapabilities.chrome();
//        capability.setCapability("version", "65");
//
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-105.element34.net/wd/hub"), capability);
//        driver.manage().window().maximize();
//        driver.get(url);
//        System.out.println(driver.getTitle());
//        Thread.sleep((long)(Math.random() * 20000));
//
//        driver.quit();
//    }


    @Test
    public void failedTest() throws IOException, InterruptedException {


        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        WebDriverWait wait =  new WebDriverWait(getDriver(), 10);
        getDriver().manage().window().maximize();
        logVideoUrl(driver);


        try {
            driver.get("https://www.newyorkfed.org/");
            WebElement searchbox = driver.findElement(By.id("searchbox"));
            searchbox.clear();
            searchbox.sendKeys("interest rates");
            searchbox.sendKeys(Keys.ENTER);

            Assert.assertTrue(false);
//            wait.until(ExpectedConditions.titleIs("Search - FEDERAL RESERVE BANK of NEW YORK"));
            //Assert.assertEquals(driver.getCurrentUrl(), "Google" );
        }
        finally {
            logVideoUrl(driver);
            Thread.sleep(5000);
        }

    }



    private String printVideoURL(RemoteWebDriver driver) {
        return ("https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");
    }

    private void logVideoUrl(RemoteWebDriver driver) {
        Reporter.log("<a href=" + printVideoURL(driver) + ">Click here for a video of this test</a>");

    }
}
