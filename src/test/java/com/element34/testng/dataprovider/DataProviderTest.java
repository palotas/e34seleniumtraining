/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Using data providers creates a lot of tests.
 * It creates a "unit of test". If one of the N test fails, you will need
 * to rerun the N tests.
 */
public class DataProviderTest {

  @DataProvider(name = "credential")
  public Object[][] getString() {
    return new Object[][]{
        {"user1",""}, {"user2",null}
    };
  }

  @Test(dataProvider = "credential")
  public void login(String user,String password) {
    System.out.println("user:"+user + " pass:"+password);
  }
}
