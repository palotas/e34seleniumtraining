/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.order;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import static com.element34.testng.report.Simple.sleepTight;


public class Listener2 implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    sleepTight(1000);
    System.out.println("I'm " + getClass().getSimpleName());
  }

  @Override
  public void onFinish(ISuite suite) {

  }
}