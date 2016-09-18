package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by gridfusion on 07/05/16.
 */
public class SelectPageObjectTest {


    @Test
    public void testpageTest() throws InterruptedException, FileNotFoundException, IOException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(capabilities);

        driver.get("http://www.element34.net/testpage");

        SelectPageObject mypage = new SelectPageObject(driver);
        mypage.selectDropdown();

        Thread.sleep(3000);
        driver.quit();

    }
}
