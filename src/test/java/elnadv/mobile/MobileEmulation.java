/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.mobile;

import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static sbox.Settings.HUB;

public class MobileEmulation extends BaseTest {

    @DataProvider(name = "devices", parallel = true)
    public Object[][] devices() {
        return new Object[][] {
                {"iPhone 8"},
                {"iPad Pro"},
                {"Galaxy S5"},
                {"Nexus 10"},
        };
    }

    @Test
    public void mobile() throws InterruptedException {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPad");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://anaplan.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(dataProvider = "devices")
    public void mobileSBOX(String device) throws InterruptedException, MalformedURLException {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", device);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        chromeOptions.setCapability("e34:token" , "b280dc6d-0d25-45");
        chromeOptions.setCapability("e34:video" , true);
        chromeOptions.setCapability("e34:l_testName", "SBOX Mobile Emulation - " + device);
        RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB + "/wd/hub"), chromeOptions);
        driver.get("https://rbinternational.com");
        Thread.sleep(15000);
        driver.quit();
    }
}
