/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.thread;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite.ParallelMode;


/**
 * sequantial : share a thread.
 * parallel = method: 1 method per thread.
 * parallel = method BUT dependOnMethod : back on a single thread.
 */
public class ThreadTest {

  private final InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

  @BeforeSuite
  public void parallel(ITestContext context) {
    context.getCurrentXmlTest().setParallel(ParallelMode.METHODS);
  }

  @Test
  public void test1() {
    System.out.println("from test1 : was " + local.get());
    local.set("test1");
    throw new RuntimeException();
  }

  @Test(dependsOnMethods = "test1")
  public void test2() {
    System.out.println("from test2 : was  " + local.get());
    local.set("test2");

  }
}
