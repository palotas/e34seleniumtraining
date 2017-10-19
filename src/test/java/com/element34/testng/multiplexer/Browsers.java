/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.multiplexer;



public enum Browsers {
  Chrome(new String[]{"chrome"}),
  IE(new String[]{"internet explorer"}),
  Web(new String[]{"chrome", "firefox", "internet explorer"});
  private final String[] browsers;

  Browsers(String[] browsers) {
    this.browsers = browsers;
  }

  public String[] browsers() {
    return browsers;
  }
}
