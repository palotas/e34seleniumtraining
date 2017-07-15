package com.element34.testng.order;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.ArrayList;
import java.util.List;


public class OrderedListeners implements ISuiteListener {

  public final List<ISuiteListener> ordered = new ArrayList<>();

  public OrderedListeners(){
    ordered.add(new Listener1());
    ordered.add(new Listener2());
  }

  @Override
  public void onStart(ISuite suite) {
    for (ISuiteListener l : ordered){
      l.onStart(suite);
    }
  }

  @Override
  public void onFinish(ISuite suite) {
    for (ISuiteListener l : ordered){
      l.onFinish(suite);
    }
  }
}
