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