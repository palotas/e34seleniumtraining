/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.thread;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * To run against multiple browser but still keep the
 * parallel by class and have dependencies between method ( the setup Matthias has ),
 * one solution can be to use a factory to inject the browsers.
 */
public class MultiDriverTest {

  private final String driver;

  @Factory
  public Object[] factory(){
    return new Object[]{
      new MultiDriverTest("firefox"),
      new MultiDriverTest("chrome"),
    };
  }

  public MultiDriverTest(String driver) {
    this.driver = driver;
  }


  @Test
  public void test(){
    System.out.println("I'm "+driver);
  }

  @Test
  public void test2(){
    System.out.println("I'm "+driver);
  }

}
