/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.groups;

import org.testng.annotations.Test;


public class groups {
	
	@Test(groups= {"regression", "nightly"})
	public void test1() {
		System.out.println("test1...");
	}
	
	@Test(groups= {"regression", "smoketest"})
	public void test2() {
		System.out.println("test2...");
	}	

	@Test(groups= {"regression"})
	public void test3() {
		System.out.println("test3...");
	}	

	@Test
	public void test4()  {
		System.out.println("test4...");
	}

}
