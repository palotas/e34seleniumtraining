package com.element34.webdriver.profile;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * - injecting a firefox profile with gecko
 * - targeting multiple installs of firefox (  cap.setCapability("firefox_binary",XXX)
 */
public class FirefoxProfileTest {


  @Test
  public void gecko() throws MalformedURLException {

    DesiredCapabilities cap = DesiredCapabilities.firefox();
//    FirefoxProfile fp = new FirefoxProfile();
//    fp.setPreference("accessibility.AOM.enabled", true);
//    cap.setCapability(FirefoxDriver.PROFILE, fp);
    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
      driver.get("about:config");
      WebElement el = driver.findElement(By.id("warningButton"));
      el.click();

      File tmp = driver.getScreenshotAs(OutputType.FILE);
      File ss = new File("screenhot.png");
      tmp.renameTo(ss);
      System.out.println(driver.getCapabilities());
      System.out.println("Screenshot: " + ss.getAbsoluteFile());
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }

  }


  @Test
  public void test() throws MalformedURLException {
    RemoteWebDriver d = null;

    try {
      DesiredCapabilities cap = DesiredCapabilities.firefox();
      cap.setCapability("firefox_binary", "/Users/freynaud/esr/Firefox_52.app/Contents/MacOS/firefox-bin");
      d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
      System.out.println(d.getCapabilities());
      d.get("http://google.com");
      WebElement el = d.findElement(By.name("q"));
      ((JavascriptExecutor) d).executeScript("arguments[0].style.border='3px solid red'", el);

       el.sendKeys("ca");
    } finally {
      if (d != null) {
        d.quit();
      }
    }
  }


}
