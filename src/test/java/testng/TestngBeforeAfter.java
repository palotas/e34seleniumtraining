package testng;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestngBeforeAfter {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite...");
	}	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite...");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method...");
	}
	
			
	//actual tests
	@Test
	public void mytest1() {
		System.out.println("mytest1...");
	}
	
	@Test
	public void mytest2() {
		System.out.println("mytest2...");		
	}	

	@Test
	public void mytest3() {
		System.out.println("mytest3...");	
	}	
}
