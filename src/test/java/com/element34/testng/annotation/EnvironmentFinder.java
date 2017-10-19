/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.annotation;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class EnvironmentFinder implements IInvokedMethodListener2 {

  public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    if (method.isTestMethod()) {
      Test test = getAnnotation(method);
      for (String group : test.groups()) {
        if (group.equals("regression")) {
          // found something that looks like an envt.
          Environment environment = new Environment("http://regression.element34.com");
          Environment.set(environment);
          return;
        }
        if (group.equals("smoke")) {
          // found something that looks like an envt.
          Environment environment = new Environment("http://smoke.element34.com");
          Environment.set(environment);
          return;
        }
        if (group.equals("production")) {
          // found something that looks like an envt.
          Environment environment = new Environment("http://element34.com");
          Environment.set(environment);
          return;
        }
      }
    }
  }

  public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

  }

  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

  }

  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

  }

  private Test getAnnotation(IInvokedMethod method) {
    return method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
  }
}
