package factory;
import org.openqa.selenium.WebDriver;

/**
 * Created by e34 on 01.01.17.
 */


public class LocalDriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
