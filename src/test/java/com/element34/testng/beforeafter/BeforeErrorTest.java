/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.beforeafter;

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
public class BeforeErrorTest {

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
