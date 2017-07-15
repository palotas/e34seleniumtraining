package com.element34.testng.config;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * If a Before config method throws, the after won't run.
 * Try to avoid having steps that throw exceptions in the before methods
 * or you may not cleanup everything.
 *
 * Adding alwaysRun=true forces the teardown to be executed
 * It is false by default.
 */
public class ConfigurationTest {

  @BeforeClass()
  public void setup() {
    System.out.println("before");
    //throw new RuntimeException("error");
  }

  @Test
  public void test() throws Exception {
    System.out.println("test");
    throw new SkipException("error");
  }

  @AfterClass //(alwaysRun = true)
  public void teardwon() {
    System.out.println("after");
  }
}
