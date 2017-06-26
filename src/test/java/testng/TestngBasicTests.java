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
		System.out.println("c =" + c);
	}
	
}
