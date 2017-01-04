package factory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by e34 on 01.01.17.
 */
public class Tests {

    @Test
    public void test1() {
        WebDriver driver = LocalDriverManager.getDriver();
        driver.get("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google1");
    }
}
