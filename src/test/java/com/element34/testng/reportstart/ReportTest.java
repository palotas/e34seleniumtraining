package com.element34.testng.reportstart;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyReport.class)
public class ReportTest {


  @Test
  public  void test(){
    Reporter.log("Hello");
  }
}
