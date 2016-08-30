package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by gridfusion on 07/05/16.
 */
public class SelectPageObjectTest {


    @Test
    public void testpageTest() throws InterruptedException, FileNotFoundException, IOException {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://gridfusion.net/testpage.html");

        SelectPageObject mypage = new SelectPageObject(driver);
        mypage.selectDropdown();

        Thread.sleep(3000);
        driver.quit();

    }
}
