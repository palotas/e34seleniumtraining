package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by e34 on 01.01.17.
 */
@Listeners(ParallelListener.class)
public class DriverFactoryTest {

    @BeforeTest
    public void setup() {
    }


    @Test
    public void test1() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        try {

            driver.get("http://www.google.com");
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "Google1");
        }
        finally {
            driver.quit();
        }

    }

    @Test
    public void test2() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        try {

            driver.get("http://www.google.com");
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "Google1");
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void test3() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        try {

            driver.get("http://www.google.com");
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "Google1");
        } finally {
            driver.quit();
        }
    }
}
