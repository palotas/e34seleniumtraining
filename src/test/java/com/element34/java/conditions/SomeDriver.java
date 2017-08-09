package com.element34.java.conditions;


public class SomeDriver {

  private final int maxFails;
  private int fails = 0;

  public SomeDriver(int fails) {
    this.maxFails = fails;
  }


  public SomeWebElement findElement() {
    fails++;
    if (fails < maxFails) {
      System.err.println("HorribleException");
      throw new HorribleException();
    } else if (fails == maxFails) {
      return new SomeWebElement(
          "loading...");
    } else {
      return new SomeWebElement(
          "expected");
    }
  }
}
