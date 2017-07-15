package com.element34.testng;

import com.element34.testng.report.JsonReporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * using the reporter that produces json.
 */
@Listeners(JsonReporter.class)
public class Demo {

  @Test
  public void test(){}
}
