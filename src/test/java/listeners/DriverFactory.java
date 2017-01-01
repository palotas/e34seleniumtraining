package listeners;

/**
 * Created by e34 on 01.01.17.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory
{

    private DriverFactory()
    {
        //Do-nothing..Do not allow to initialize this class from outside
    }
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected RemoteWebDriver initialValue()
        {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            RemoteWebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps); // can be replaced with other browser drivers
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }
}
