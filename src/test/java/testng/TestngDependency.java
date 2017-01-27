package testng;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestngDependency {

	@Test
	public void mytest1() {
		int a=1;
		int b=2;
		int c;
		c=a + b;
		System.out.println("mytest1...");		
		Assert.assertTrue(c==5); //this test will fail

	}
	
	@Test(dependsOnMethods={"mytest1"})
	public void mytest2() {
		System.out.println("mytest2...");	
		
		//force test to pass -> do not do this in "real" life
		Assert.assertTrue(true); 
	}	
	
    @Test
    public void mytest3() {
		System.out.println("mytest3...");	
		Assert.assertTrue(true);
	}	
    
    @Test
	public void mytest4() {
		System.out.println("mytest4...");	
		Assert.assertTrue(true);
	}	
}
