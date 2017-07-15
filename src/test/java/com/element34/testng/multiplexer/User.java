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
