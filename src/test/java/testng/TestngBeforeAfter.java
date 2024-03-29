/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestngBeforeAfter {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite...");
	}	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite...");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method...");
	}
	
			
	//actual tests
	@Test
	public void test1() {
		System.out.println("test1...");
	}
	
	@Test
	public void test2() {
		System.out.println("test2...");
	}	

	@Test
	public void test3() {
		System.out.println("test3...");
	}	
}
