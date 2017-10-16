package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static elnadv.Helpers.sleepTight;

/**
 * Created by e34 on 13/10/2017.
 */
public class EventFiring extends BaseTest{

    @Test
    public void eventFiringDriver() throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        EventFiringWebDriver firingDriver = new EventFiringWebDriver(driver);
        EventListener eventListener = new EventListener(driver);
        firingDriver.register(eventListener);


        firingDriver.get("chrome://chrome-urls");
        sleepTight(2000);
        WebElement el = firingDriver.findElement(By.linkText("chrome://about"));
        el.click();
        firingDriver.quit();
    }
}
