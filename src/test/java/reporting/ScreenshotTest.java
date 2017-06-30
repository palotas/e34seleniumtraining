package reporting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class ScreenshotTest {

    @Test
    public void testWithScreenshotAndReportRemote() throws Exception {

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("firefox");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        driver.get("http://www.element34.net");
        DoScreenshot.remoteWebDriverScreenshot((RemoteWebDriver) driver);
        driver.quit();
    }
}
