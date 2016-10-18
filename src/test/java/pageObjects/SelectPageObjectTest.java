package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by gridfusion on 07/05/16.
 */
public class SelectPageObjectTest {

    @BeforeTest
    public void setup() {
        String OS = System.getProperty("os.name");

        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }


    @Test
    public void testpageTest() throws InterruptedException, IOException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        WebDriver driver = new FirefoxDriver(capabilities);

        driver.get("http://www.element34.net/testpage");

        SelectPageObject mypage = new SelectPageObject(driver);
        mypage.selectDropdown();

        Thread.sleep(3000);
        driver.quit();

    }
}
