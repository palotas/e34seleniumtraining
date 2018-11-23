/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Settings.HUB;

public class SboxMobileDemo {


    @Test(invocationCount = 10, threadPoolSize = 10)
    public void downloadApkFromUrlAndRunNativeTest() throws IOException {
        String appLocation = "http://static.element34.net/mobile/demo_apks/ApiDemos-debug.apk";
        mobileNativeTest(appLocation);
    }

    private void mobileNativeTest(String appLocation) throws MalformedURLException {
        // DesiredCapabilities caps = DesiredCapabilities.android();
        String threadInfo = String.format("%s - %s", Thread.currentThread().getId(), Thread.currentThread().getName());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability("e34:token", "19705d15-03b8-4f");
        caps.setCapability("e34:app", appLocation);
        caps.setCapability("e34:l_testName", "nativeApp " + threadInfo);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");

        AndroidDriver driver = new AndroidDriver(new URL(HUB), caps);
        Wait<AndroidDriver> wait = new FluentWait<>(driver)
                //.withTimeout(Duration.ofSeconds(30))
                .ignoring(NotFoundException.class)
                .ignoring(WebDriverException.class);
        try {
            MobileElement accessibility = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility"));
            accessibility.click();
            MobileElement accessibilityService = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
            accessibilityService.click();
            wait.until(androidDriver -> driver.findElementById("io.appium.android.apis:id/button"));
            driver.navigate().back();
            wait.until(androidDriver -> driver.findElementByAccessibilityId("Accessibility Service"));
            driver.navigate().back();
            MobileElement app = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("App"));
            app.click();
            MobileElement alertDialogs = (MobileElement) wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
            alertDialogs.click();
            wait.until(androidDriver -> driver.findElementByAccessibilityId("List dialog"));
            driver.navigate().back();
            wait.until(androidDriver -> driver.findElementByAccessibilityId("Alert Dialogs"));
            driver.navigate().back();
        } finally {
            driver.quit();
        }
    }
}
