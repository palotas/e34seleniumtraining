package com.element34.testng.report;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.element34.testng.report.Simple.sleepTight;


public class DataProviderTest {
  @DataProvider(name = "data",parallel = true)
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
