package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngBasicTests {
	
	
	@Test(invocationCount=3)
	public void myFirstTestngTest() {
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);
		System.out.println("myFirstTestngTest...");	
	}

	
	@Test
	public void mySecondTestngTest() {
		System.out.println("mySecondTestngTest...");	
	}

	@Test
	public void myThirdTestngTest() {
		System.out.println("myThirdTestngTest...");	
	}	
	
}
