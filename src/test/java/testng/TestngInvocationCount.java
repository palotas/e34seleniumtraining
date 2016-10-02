package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngInvocationCount {
	
	//this test will be executed 10 times 
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
