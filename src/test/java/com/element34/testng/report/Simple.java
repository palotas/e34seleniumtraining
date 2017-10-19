/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.report;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class Simple {

  private static final int wait = 5000;

  @Test
  public void pass() throws InterruptedException {
    sleepTight();

  }

  @DataProvider(name = "data", parallel = true)
  public Object[][] data() {
    return new Object[][]{
        {"A"},
        {"B"}
    };
  }

  @Test(dataProvider = "data")
  public void lotsOfLogs(String s) throws InterruptedException {
    int i = 0;
    sleepTight();

  }

  @Test
  public void fail() throws Exception {
    sleepTight();
    throw new Exception("some error");
  }

  @Test
  public void lotsOfLogs2() throws InterruptedException {
    int i = 0;
    i++;
    sleepTight();
  }

  @Test
  public void skip() throws Exception {
    sleepTight();
    throw new SkipException("some skipped error");
  }

  public static void sleepTight(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
    }
  }

  public static void sleepTight() {
    int randomNum = ThreadLocalRandom.current().nextInt(0, wait + 1);
    sleepTight(randomNum);
  }
}