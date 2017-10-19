/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.multiplexer;

/**
 * Created by freynaud on 01/06/2017.
 */
public class User {

  private final String name;

  public User(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
