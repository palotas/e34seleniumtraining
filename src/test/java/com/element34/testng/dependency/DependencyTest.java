/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.dependency;


import org.testng.annotations.Test;

import static com.element34.testng.report.Simple.sleepTight;

/**
 * Having dependencies looks nice on powerpoint, but it often gets in the way.
 * It makes it harder to rerun just the fails, and you need to rerun the complete chain.
 * Sharing data between tests + having dependencies break the "isolation of tests" concept.
 */
public class DependencyTest {

  @Test
  public void dbUp() {
    sleepTight(1000);
  }


  @Test(dependsOnMethods = "dbUp")
  public void login() {
    sleepTight(5000);

  }

  @Test(dependsOnMethods = "login")
  public void homePage() {
    sleepTight(10000);

  }

  @Test(dependsOnMethods = "homePage")
  public void page2() throws Exception {
    System.out.println("page 2 !");
    throw new Exception("error");
  }
}
