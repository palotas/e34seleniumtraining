/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class LiveReport implements ITestListener {


  private String name(ITestResult result) {
    return result.getMethod().getConstructorOrMethod().getName();
  }

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println(name(result) + " started");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("[OK]" +name(result));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.err.println("[FAIL]" +name(result));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("[SKIPPED]" +name(result));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {

  }
}
