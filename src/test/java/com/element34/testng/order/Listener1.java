package com.element34.testng.order;

import com.element34.testng.report.Simple;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static com.element34.testng.report.Simple.sleepTight;

/**
 * Created by freynaud on 31/05/2017.
 */
public class Listener1 implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    Simple.sleepTight(1000);
    System.out.println("I'm " +getClass().getSimpleName());
  }

  @Override
  public void onFinish(ISuite suite) {

  }
}
