/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.multiplexer;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.internal.MethodInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * Takes the list of browsers in the @WetTest annotation, and create one test per browser.
 */
public class Multiplexer implements IMethodInterceptor {

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    List<IMethodInstance> instances = new ArrayList<>();
    for (IMethodInstance method : methods) {
      instances.addAll(multi(method, context));
    }
    return instances;
  }

  private List<IMethodInstance> multi(IMethodInstance instance, ITestContext context) {
    List<IMethodInstance> instances = new ArrayList<>();

    WebTest webTest = instance.getMethod().getConstructorOrMethod().getMethod().getAnnotation(WebTest.class);
    if (webTest != null) {
      ITestNGMethod original = instance.getMethod();
      String[] browsers = webTest.browsers().browsers();
      for (String browser : browsers) {

        // TODO : there is a bug here. For metadata to be bound to a single test instance, method with invocationCount of N
        // need to to be cloned N times with an invocation count of 1. Otherwise the N method will share 1 metadata object.
        ITestNGMethod clone = original.clone();
        MethodInstance newInstance = new MethodInstance(clone);
        Metadata.getMetadata(clone).put("browser", browser);
        instances.add(newInstance);
      }
    } else {
      instances.add(instance);
    }
    return instances;
  }
}
