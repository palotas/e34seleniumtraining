/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

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

  @Test(groups = {"production"})
  public void envtAware3() {
    System.out.println("envtAware3 is using "+Environment.env());
  }
}
