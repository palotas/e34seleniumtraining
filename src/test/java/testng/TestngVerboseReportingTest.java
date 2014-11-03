package testng;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngVerboseReportingTest {
	
	
	@Test
	public void myFirstTestngTest() {
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		//Assert.assertTrue(c==3);
		Reporter.log("logging here", 2, true);
	}

	

	
}
