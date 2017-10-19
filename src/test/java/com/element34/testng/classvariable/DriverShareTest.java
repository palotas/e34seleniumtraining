/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.classvariable;


import com.element34.java.conditions.SomeDriver;
import com.element34.testng.report.Simple;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.element34.testng.report.Simple.sleepTight;

/**
 * Having class level variable will prevent running methods in parallel.
 */
public class DriverShareTest {

  private SomeDriver driver;

  @BeforeMethod
  public void setup(){
    driver = new SomeDriver(0);
  }


  @Test(invocationCount = 5,threadPoolSize = 5)
  public void webtest(){
    Simple.sleepTight();
    Assert.assertNotNull(driver);
  }

  @AfterMethod
  public void teardown(){
    driver = null;
  }

}
