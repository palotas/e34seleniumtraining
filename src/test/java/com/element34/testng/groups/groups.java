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
