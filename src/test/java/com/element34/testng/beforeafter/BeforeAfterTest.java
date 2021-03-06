/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.beforeafter;

import org.testng.annotations.*;

/**
 * Showing the order of the testNG building blocks:
 * - suite
 *  - test
 *    - class
 *      - method
 *        - method instance
 */
public class BeforeAfterTest {


  public BeforeAfterTest(){
    System.out.println("constructor\n");
  }

  @BeforeClass
  public void clazz(){
    System.out.println("class");
  }

  @BeforeMethod
  public void method(){
    System.out.println("method");
  }

  @BeforeSuite
  public void suite(){
    System.out.println("suite");
  }
  @BeforeTest
  public void test(){
    System.out.println("test");
  }



  @Test
  public void test1(){
    System.out.println("test1");
  }


  @Test(invocationCount = 2)
  public void test2(){
    System.out.println("test2");
  }
}
