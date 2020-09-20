/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestngDataProvider {
	
	//data provider with one parameter
	@DataProvider(name = "countryprovider", parallel = false)
	public Object[][] createData1() {
	 return new Object[][] {
	   {"user1@axa.ch"},
	   {"user2"},
	   {"China"},
	   {"Germany"}
	 };
	}

	//data provider with two parameters
	@DataProvider(name = "urlprovider", parallel = true)
	public Object[][] createData2() {
	 return new Object[][] {
	   {"user1", "pw1"},
	   {"user2", "pw2"}
	 };
	}
	
	//use dataprovider1 and pass the value as String s
	@Test(dataProvider="countryprovider")
	public void mytest1(String s) throws InterruptedException {
		System.out.println("now testing: "+ s);
		Thread.sleep(2000);
	}
	
	//use dataprovider2 and pass two parameters as Strings site and s
	@Test(dataProvider="urlprovider")
	public void mytest2(String user, String pw) throws InterruptedException {
		method1();
		method2();
		method3();
		System.out.println("User " + user + "  PW:" + pw);
		Thread.sleep(2000);
	}

	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}

	public void method3() {
		System.out.println("method3");
	}






	@Test(invocationCount = 5, threadPoolSize = 2)
	public void parallel() throws InterruptedException {
		System.out.println("hello world");
		Thread.sleep(2000);
	}
}
