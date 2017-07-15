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
