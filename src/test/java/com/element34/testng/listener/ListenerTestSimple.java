package com.element34.testng.listener;


import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by e34 on 31.12.16.
 */

//@Listeners({StatusListener.class})
public class ListenerTestSimple {

    @Test
    public void simpleListenerTest() throws Exception {

        System.out.println("this is a simple listener test");
        Assert.assertTrue(false);

    }

}
