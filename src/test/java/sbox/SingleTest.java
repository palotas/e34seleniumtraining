/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static sbox.Settings.HUB;

public class SingleTest {

    @Test
    public void ciscoFF() throws IOException, InterruptedException {


        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.link.open_newwindow", 3);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), options);
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        Thread.sleep(5000);

        driver.quit();
    }
}
