package listeners;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
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

@Listeners({ParallelListener.class, StatusListener.class})
public class ListenerTest {

    private RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void createDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }


    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }

        }
    }


    @Test
    public void webtest1() throws Exception {

            driver.get("http://www.spiegel.de");
            System.out.println(driver.getTitle());
            Assert.assertTrue(false);

    }

}
