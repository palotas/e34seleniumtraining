/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.annotations.Test;


public class TestngGroups {
	
	@Test(groups= {"regression", "broken"})
	public void mytest1() {
		System.out.println("mytest1...");		
	}
	
	@Test(groups= {"regression", "smoketest"})
	public void mytest2() {
		System.out.println("mytest2...");		
	}	

	@Test(groups= {"regression"})
	public void mytest3() {
		System.out.println("mytest3...");	
	}	

}
