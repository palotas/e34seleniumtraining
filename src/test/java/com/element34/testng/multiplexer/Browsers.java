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
