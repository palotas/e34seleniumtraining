/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestngDependency {

	@Test
	public void mytest1() {
		int a=1;
		int b=2;
		int c;
		c=a + b;
		System.out.println("mytest1...");		
		Assert.assertTrue(c==3);

	}
	
	@Test(dependsOnMethods={"mytest1"})
	public void mytest2() {
		System.out.println("mytest2...");	
	}
}
