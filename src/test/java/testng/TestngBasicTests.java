package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngBasicTests {
	
	
	@Test
	public void myFirstTestngTest() {
		int a = 3;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertEquals(c, 4);
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
