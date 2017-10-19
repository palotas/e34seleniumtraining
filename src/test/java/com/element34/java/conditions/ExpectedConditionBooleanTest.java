/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.java.conditions;


import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * An example of a fluent wait without using the ExpectedConditions from webdriver.
 * More common interfaces for day to day case : https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 */
public class ExpectedConditionBooleanTest {


  @Test
  public void test() {

    // create dummy driver that fails N times.
    SomeDriver webdriver = new SomeDriver(3);

    SomeParameter param = new SomeParameter("expected");
    SomeCondition condition = new SomeCondition(param);

    FluentWait<SomeDriver> wait = new FluentWait<>(webdriver)
        .withTimeout(5, TimeUnit.SECONDS)
        .ignoring(HorribleException.class)
        .pollingEvery(500, TimeUnit.MILLISECONDS);
    SomeWebElement el = wait.until(condition);





    System.out.println("Got element : " + el);
  }

  // TODO : IDE


}
