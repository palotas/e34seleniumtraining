/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngInvocationCount {
	
	@Test(invocationCount=10)
	public void invocationCountTest() {
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);
		System.out.println("invocationCountTest...");	
	}	
}
