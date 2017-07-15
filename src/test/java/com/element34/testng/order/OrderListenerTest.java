package com.element34.testng.order;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * By default, listeners will run in random order.
 */
// random order
//@Listeners({Listener1.class,Listener2.class})
// ordered
@Listeners({OrderedListeners.class})
public class OrderListenerTest {

  @Test
  public void test(){

  }
}
