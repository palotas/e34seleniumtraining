package testng;

import org.testng.annotations.Test;


public class TestngGroups {
	
	@Test(groups= {"regression", "nightly"})
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

	@Test
	public void mytest4() {
		System.out.println("mytest4...");	
	}	

}
