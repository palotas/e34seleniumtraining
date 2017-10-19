/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.java.conditions;


public class SomeWebElement {

  private String name;

  public SomeWebElement(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return name;
  }
}
