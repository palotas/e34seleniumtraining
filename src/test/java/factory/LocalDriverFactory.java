package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by e34 on 01.01.17.
 */
public class LocalDriverFactory {

        static WebDriver createInstance(String browserName) throws MalformedURLException {
            WebDriver driver = null;
            if (browserName.toLowerCase().contains("firefox")) {
                driver = new FirefoxDriver();
                return driver;
            }
            if (browserName.toLowerCase().contains("internet")) {
                driver = new InternetExplorerDriver();
                return driver;
            }
            if (browserName.toLowerCase().contains("chrome")) {
                driver = new ChromeDriver();
                return driver;
            }
            else {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
            }
            return driver;
        }
}

