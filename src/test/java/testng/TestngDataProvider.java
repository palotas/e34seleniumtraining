package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestngDataProvider {
	
	//data provider with one parameter
	@DataProvider(name = "dataprovider1")
	public Object[][] createData1() {
	 return new Object[][] {
	   {"Switzerland"},
	   {"United States"},
	   {"China"},
	   {"Germany"}
	 };
	}

	//data provider with two parameters
	@DataProvider(name = "dataprovider2")
	public Object[][] createData2() {
	 return new Object[][] {
	   {"Switzerland", ".ch"},
	   {"United States", ".com"},
	   {"China", ".cn"}
	 };
	}
	
	//use dataprovider1 and pass the value as String s
	@Test(dataProvider="dataprovider1")
	public void mytest1(String s) {
		System.out.println("now testing: "+ s);		
	}
	
	//use dataprovider2 and pass two parameters as Strings site and s
	@Test(dataProvider="dataprovider2")
	public void mytest2(String country, String s) {
		System.out.println("URL of " + country + ": " + "http://gridfusion" + s);		
	}
}
