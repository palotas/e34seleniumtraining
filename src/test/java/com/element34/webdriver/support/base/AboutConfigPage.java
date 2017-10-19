/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.webdriver.support.base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Example of a page object using the support UI package.
 */
public class AboutConfigPage {

  private static final String URL = "about:config";


  private WebElement warningButton;

  public AboutConfigPage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void acceptResponsibility() {
    warningButton.click();
  }

  public static AboutConfigPage get(RemoteWebDriver driver) {
    driver.get(URL);
    return new AboutConfigPage(driver);
  }
}
