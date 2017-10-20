/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.report;

import com.fasterxml.jackson.databind.ser.Serializers;
import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static elnadv.Helpers.screenshot;


public class ScreenshotTest extends BaseTest {

  @Test
  public  void test1(){

    WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    screenshot((RemoteWebDriver) driver);
    driver.quit();
  }
}
