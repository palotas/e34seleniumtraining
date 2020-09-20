/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class TestngDependencyFactory {

	private final String msg;

	public TestngDependencyFactory(String msg) {
		this.msg = msg;
	}

	@Factory()
	public Object[] getTestClasses() {
		Object[] tests = new Object[3];
		tests[0] = new TestngDependencyFactory("i1");
		tests[1] = new TestngDependencyFactory("i2");
		tests[2] = new TestngDependencyFactory("i3");
		return tests;
	}

	@Test
	public void test1() {
		System.out.println("test1"+msg);
	}


	@Test
	public void test2() throws Exception {
		System.out.println("test2"+msg);
	}

	@Test(dependsOnMethods = {"test1","test2"})
	public void test3() {
		System.out.println("test3"+msg);
	}

}




