/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.report;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.element34.testng.report.Simple.sleepTight;


public class DataProviderTest {
  @DataProvider(name = "data",parallel = false)
  public Object[][] data() {
    return new Object[][]{
        {"A", "A", 1},
        {"B", "B", 2},
        {"B", "A", 2},
    };
  }


  @Test(dataProvider = "data")
  public void testWithData(String value, String expected, int i) {
    sleepTight();
    Assert.assertEquals(value, expected);
  }
}
