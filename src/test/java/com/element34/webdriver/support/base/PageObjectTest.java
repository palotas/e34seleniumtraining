package com.element34.webdriver.support.base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class PageObjectTest {

  @Test
  public void aboutConfig() throws MalformedURLException {
    RemoteWebDriver driver = null;
    long start = 0;
    try {
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
      // driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      AboutConfigPage page = AboutConfigPage.get(driver);
      // start = System.currentTimeMillis();
      page.acceptResponsibility();
    } catch (Exception e) {
      System.err.println("error");
    } finally {
      // System.out.println((System.currentTimeMillis() - start) + "ms");
      if (driver != null) {
        driver.quit();
      }
    }

  }
}
