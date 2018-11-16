/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngBasicTests {
	
	
	@Test
	public void myFirstTestngTest() {
		int a = 2;
		int b = 3;
		int c;
		c = a + b;
		Assert.assertEquals(c, 5);
		System.out.println("c = " + c);
	}
	
}
