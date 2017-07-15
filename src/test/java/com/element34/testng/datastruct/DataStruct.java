package com.element34.testng.datastruct;

import org.testng.annotations.*;

/**
 * Showing the order of the testNG building blocks:
 * - suite
 *  - test
 *    - class
 *      - method
 *        - method instance
 */
public class DataStruct {


  public DataStruct(){
    System.out.println("constructor");
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
