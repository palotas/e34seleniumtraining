/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

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
