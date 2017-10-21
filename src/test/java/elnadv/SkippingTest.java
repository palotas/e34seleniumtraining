/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e34 on 13/10/2017.
 */
public class SkippingTest extends BaseTest {

    public final static String[] CHROME_SKIP_VERSIONS = {"58"};


    @DataProvider(name = "chromeVersions", parallel = false)
    public Object[][] createVersions1() {
        return new Object[][] {
                {"61"},
                {"60"},
                {"59"},
                {"58"}
        };
    }


    @Test(dataProvider = "chromeVersions")
    public void skipTestForCertrainVersions(String version) {


        checkChromeVersionToSkip(version);
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://google.com");
        }
        finally {
            driver.quit();
        }
    }

    public static void checkChromeVersionToSkip(String version) {
        List<String> versionList = new ArrayList<>();
        for (int i = 0; i < CHROME_SKIP_VERSIONS.length; i++) {
            versionList.add(CHROME_SKIP_VERSIONS[i]);
        }

        if (versionList.contains(version)) {
            throw new SkipException("unsupported Chrome Version for this feature ");
        }
    }
}
