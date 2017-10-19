/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.annotation;


public class Environment {

  public final String name;

  public Environment(String name) {
    this.name = name;
  }

  private static InheritableThreadLocal<Environment> env = new InheritableThreadLocal<Environment>();

  public static Environment env() {
    return env.get();
  }

  static void set(Environment environment) {
    env.set(environment);
  }

  @Override
  public String toString() {
    return name;
  }
}
