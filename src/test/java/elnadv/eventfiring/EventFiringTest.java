/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.eventfiring;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static elnadv.Helpers.sleepTight;

/**
 * Created by e34 on 13/10/2017.
 */
public class EventFiringTest extends BaseTest {

    @Test
    public void eventFiringDriver() throws MalformedURLException {

        RemoteWebDriver driver = new ChromeDriver();

        EventFiringWebDriver firingDriver = new EventFiringWebDriver(driver);
        MyEventListener myEventListener = new MyEventListener(driver);
        firingDriver.register(myEventListener);

        firingDriver.get("https://element34.com/testpage");
        firingDriver.findElement(By.linkText("Home")).click();
        sleepTight(1000);
        firingDriver.findElement(By.linkText("Consulting")).click();
        sleepTight(1000);
        firingDriver.findElement(By.linkText("Training")).click();
        sleepTight(1000);

        firingDriver.quit();
    }
}
