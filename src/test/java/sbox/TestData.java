/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;

import static sbox.Helpers.getAllChromes;

public class TestData {

    @DataProvider(name = "sBoxBrowsersProvider", parallel=true)
    public Object[][] getRemoteDrivers() throws MalformedURLException {

        // Return Firefox capabilities object
        DesiredCapabilities firefoxCapabs = DesiredCapabilities.firefox();

        //firefoxCapabs.setPlatform(Platform.LINUX);
        //firefoxCapabs.setCapability("e34:auth", "sjej35po2vgxd7yg");
        //firefoxCapabs.setCapability("e34:video", true);
        //firefoxCapabs.setCapability("acceptInsecureCerts", true);


        // Return Chrome capabilities object
        DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();

        chromeCaps.setPlatform(Platform.LINUX);
        chromeCaps.setCapability("e34:auth", "sjej35po2vgxd7yg");
        chromeCaps.setCapability("e34:video", true);
        chromeCaps.setCapability("acceptInsecureCerts", true);


        return new Object[][]{
                {firefoxCapabs},
                //{chromeCaps}
        };

    }


    @DataProvider(name = "testnames", parallel = true)
    public Object[][] testnames() {
        return new Object[][] {
                {"DE Sign in test", "https://sbb.ch"},
                {"US Sign in test", "https://google.com"},
                {"FR Checkout test ", "https://ricardo.ch"},
                {"CH Registration test ", "https://digitec.ch"},
                {"DE Sign in test", "https://sbb.ch"},
                {"US Sign in test", "https://google.com"},
                {"FR Checkout test ", "https://ricardo.ch"},
                {"CH Registration test ", "https://digitec.ch"},
                {"DE Sign in test", "https://sbb.ch"},
                {"US Sign in test", "https://google.com"},
                {"FR Checkout test ", "https://ricardo.ch"},
                {"CH Registration test ", "https://digitec.ch"},
        };
    }

    @DataProvider(name = "urls", parallel = true)
    public Object[][] urls() {
        return new Object[][] {
                {"https://element34.com/testpage"},
                {"http://static.element34.net/e34"},
                {"http://static.element34.net/the-internet"}
        };
    }

    @DataProvider(name = "tokens", parallel = true)
    public Object[][] tokens() {
        return new Object[][] {
                {"57ffedec"},
                {"636d9925"},
                {"ce8a0923"}
        };
    }


    @DataProvider(name = "chromeVersions", parallel = true)
    public Object[][] createVersions1() {
        return new Object[][] {
                {"64"},
                {"63"},
                {"62"},
                {"61"},
                {"60"}
        };
    }

    @DataProvider(name = "chromeVersions2", parallel = true)
    public Object[][] createVersions2() {
        return getAllChromes();
    }

    @DataProvider(name = "browserProvider", parallel = true)
    public Object[][] getDrivers() {

        DesiredCapabilities chrome1 = DesiredCapabilities.chrome();
        chrome1.setCapability("version", "72");

        DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
        chrome2.setCapability("version", "71");

        DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
        chrome3.setCapability("version", "70");

        DesiredCapabilities ff1 = DesiredCapabilities.firefox();
        ff1.setCapability("version", "65");

        DesiredCapabilities ff2 = DesiredCapabilities.firefox();
        ff2.setCapability("version", "64");

        DesiredCapabilities ff3 = DesiredCapabilities.firefox();
        ff2.setCapability("version", "63");

        DesiredCapabilities internetExplorer = DesiredCapabilities.internetExplorer();

        DesiredCapabilities edge = DesiredCapabilities.edge();

        DesiredCapabilities safari = DesiredCapabilities.safari();


        return new Object[][]{
                {chrome1},
                {chrome2},
                {chrome3},
                {ff1},
                {ff2},
                {ff3},
                {internetExplorer},
                {edge},
                //{safari}
        };
    }

    @DataProvider(name="mobileprovider", parallel = true)
    public Object[][] getMobiles() {
        return new Object[][]{
                {"iPhone 7 Plus"},
                {"iPad Air"},

        };
    }


        //no hardcoded versions. Sliding window depending on what is configured on SBOX as LATEST
    @DataProvider(name = "browserProviderWithoutVersions", parallel = true)
    public Object[][] getDriversWithoutVersion() {

        //if no version is set, then latest browser version is used
        DesiredCapabilities firefox1 = DesiredCapabilities.firefox();

        //use n-1, n-1 etc. to specify non-hardcoded browserversions (sliding window)
        DesiredCapabilities firefox2 = DesiredCapabilities.firefox();
        firefox1.setCapability("version", "n-1");

        DesiredCapabilities firefox3 = DesiredCapabilities.firefox();
        firefox1.setCapability("version", "n-2");

        DesiredCapabilities chrome1 = DesiredCapabilities.chrome();

        DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
        chrome2.setCapability("version", "n-1");

        DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
        chrome3.setCapability("version", "n-2");

        return new Object[][]{
                {firefox1},
                {firefox2},
                {firefox3},
                {chrome1},
                {chrome2},
                {chrome3},
        };
    }

    @DataProvider(name = "users", parallel = true)
    public Object[][] users() {

        //babbage
        DesiredCapabilities firefoxBabbage = DesiredCapabilities.firefox();
        firefoxBabbage.setCapability("e34:token", "19705d15-03b8-4f");

        //austin
        DesiredCapabilities firefoxAustin = DesiredCapabilities.firefox();
        firefoxAustin.setCapability("e34:token", "3cff2a64-14ba-43");


        //archimedes
        DesiredCapabilities chromeArchimedes = DesiredCapabilities.chrome();
        chromeArchimedes.setCapability("e34:token", "6fadf63e-f884-44");

        return new Object[][]{
                {firefoxBabbage},
                {firefoxAustin},
//                {firefoxAustin},
//                {firefoxAustin},
//                {firefoxAustin},
                {chromeArchimedes}
        };
    }


    @DataProvider(name = "multicaps", parallel = true)
    public Object[][]  multicaps() {

        DesiredCapabilities chrome1 = new DesiredCapabilities();
        chrome1.setCapability("browserName", "chrome");
        //chrome1.setCapability("e34:userId", "michel");
        chrome1.setCapability("e34:token", "08ff3d03-543d-42");

        DesiredCapabilities chrome2 = new DesiredCapabilities();
        chrome2.setCapability("browserName", "chrome");
        chrome2.setCapability("e34:userId", "francois");

        DesiredCapabilities chrome3 = new DesiredCapabilities();
        chrome3.setCapability("e34:userId", "remo");
        chrome3.setCapability("browserName", "chrome");

        DesiredCapabilities chrome4 = new DesiredCapabilities();
        chrome4.setCapability("browserName", "chrome");

        DesiredCapabilities chrome5 = new DesiredCapabilities();
        chrome5.setCapability("browserName", "chrome");


        return new Object[][]{
                {chrome1},
                {chrome2},
                {chrome3},
                {chrome4},
                {chrome5},

        };
    }

    @DataProvider(name = "mobileDataProvider", parallel = true)
    public Object[][]  mobileDataProvider() {


        DesiredCapabilities nexus5 = new DesiredCapabilities();
        nexus5.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
        nexus5.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        nexus5.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        nexus5.setCapability(CapabilityType.VERSION, "70");
        nexus5.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
        nexus5.setCapability("e34:token", "617a27e4-c74c-46");


        DesiredCapabilities galaxyS8 = new DesiredCapabilities();
        galaxyS8.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
        galaxyS8.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        galaxyS8.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        galaxyS8.setCapability(CapabilityType.VERSION, "70");
        galaxyS8.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S8");
        galaxyS8.setCapability("e34:token", "617a27e4-c74c-46");


        DesiredCapabilities pixel2 = new DesiredCapabilities();
        pixel2.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
        pixel2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        pixel2.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        pixel2.setCapability(CapabilityType.VERSION, "70");
        pixel2.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        pixel2.setCapability("e34:token", "617a27e4-c74c-46");


        DesiredCapabilities nexus6P = new DesiredCapabilities();
        nexus6P.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
        nexus6P.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        nexus6P.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        nexus6P.setCapability(CapabilityType.VERSION, "70");
        nexus6P.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6P");
        nexus6P.setCapability("e34:token", "617a27e4-c74c-46");



        return new Object[][]{
                {nexus5},
                {galaxyS8},
                {pixel2},
                {nexus6P},
        };
    }

}
