/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class TestngDependency {

//	private final String msg;
//
//	public TestngDependency(String msg) {
//		this.msg = msg;
//	}
//
//	@Factory()
//	public Object[] getTestClasses() {
//		Object[] tests = new Object[2];
//		tests[0] = new TestngDependency("i1");
//		tests[1] = new TestngDependency("i2");
//		return tests;
//	}


//	@Test
//	public void mytest1() {
//		int a=1;
//		int b=2;
//		int c;
//		c=a + b;
//		System.out.println("mytest1...");
//		Assert.assertTrue(c==3);
//
//	}
//
//	@Test(dependsOnMethods={"mytest1"})
//	public void mytest2() {
//		System.out.println("mytest2...");
//	}


//	@Test
//	public void test1() {
//		System.out.println("test1"+msg);
//	}
//
//
//	@Test
//	public void test2() throws Exception {
//		System.out.println("test2"+msg);
//		if (msg.equals("i2")){
//			throw new Exception("error "+msg);
//		}
//	}
//
//	@Test(dependsOnMethods = {"test1","test2"})
//	public void test3() {
//		System.out.println("test3"+msg);
//	}


	@Test
	public void test1() {
		System.out.println("test1");
	}


	@Test
	public void test2() throws Exception {
		System.out.println("test2");
	}

	@Test(dependsOnMethods = {"test1","test2"}, invocationCount = 5, threadPoolSize = 5)
	public void test3() {
		System.out.println("test3");
	}

}




