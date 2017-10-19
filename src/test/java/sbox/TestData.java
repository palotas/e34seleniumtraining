/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import static sbox.Helpers.getAllChromes;

public class TestData {

    @DataProvider(name = "chromeVersions", parallel = true)
    public Object[][] createVersions1() {
        return new Object[][] {
                {""},
                {"n-1"},
                {"n-2"},
                {"n-3"}
        };
    }

    @DataProvider(name = "chromeVersions2", parallel = true)
    public Object[][] createVersions2() {
        return getAllChromes();
    }

    @DataProvider(name = "browserProvider", parallel = true)
    public Object[][] getDrivers() {

        DesiredCapabilities chrome1 = DesiredCapabilities.chrome();
        chrome1.setCapability("version", "58");

        DesiredCapabilities chrome2 = DesiredCapabilities.chrome();
        chrome2.setCapability("version", "57");

        DesiredCapabilities chrome3 = DesiredCapabilities.chrome();
        chrome3.setCapability("version", "56");

        DesiredCapabilities internetExplorer = DesiredCapabilities.internetExplorer();

        DesiredCapabilities edge = DesiredCapabilities.edge();


        return new Object[][]{
//                {chrome1},
//                {chrome2},
//                {chrome3},
//                {internetExplorer},
                {edge},
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
}
