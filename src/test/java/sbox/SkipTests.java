package sbox;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static sbox.Helpers.checkChromeVersionToSkip;

public class SkipTests {

    @Test(dataProvider = "chromeVersions2", dataProviderClass = TestData.class)
    public void skipTestsWithSpecificChromeVersions(String version) throws MalformedURLException {

        checkChromeVersionToSkip(version);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setVersion(version);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("https://vm-105.element34.net:443/wd/hub"), cap);

        } finally {
            driver.quit();
        }
    }
}