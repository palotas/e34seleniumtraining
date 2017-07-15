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
