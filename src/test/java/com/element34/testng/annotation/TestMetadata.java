package com.element34.testng.annotation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(EnvironmentFinder.class)
public class TestMetadata {


  @Test(groups = {"smoke","browser:FF+IE"})
  public void envtAware() {
    System.out.println("envtAware is using "+ Environment.env());
  }

  @Test(groups = {"regression"})
  public void envtAware2() {
    System.out.println("envtAware2 is using "+Environment.env());
  }
}
