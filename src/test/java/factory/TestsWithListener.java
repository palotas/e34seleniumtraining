package factory;

import listeners.ParallelListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by e34 on 01.01.17.
 */

@Listeners({WebDriverListener.class, ParallelListener.class})
public class TestsWithListener {

    @Test(groups = "wip")
    public void test1() {
        WebDriver driver = LocalDriverManager.getDriver();
        driver.get("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(groups = "wip", enabled = true)
    public void test2() {
        WebDriver driver = LocalDriverManager.getDriver();
        driver.get("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(enabled = false)
    public void test3() {
        WebDriver driver = LocalDriverManager.getDriver();
        driver.get("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
