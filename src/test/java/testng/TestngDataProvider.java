/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestngDataProvider {
	
	//data provider with one parameter
	@DataProvider(name = "countryprovider")
	public Object[][] createData1() {
	 return new Object[][] {
	   {"Switzerland"},
	   {"United States"},
	   {"China"},
	   {"Germany"}
	 };
	}

	//data provider with two parameters
	@DataProvider(name = "urlprovider")
	public Object[][] createData2() {
	 return new Object[][] {
	   {"Switzerland", ".ch"},
	   {"United States", ".com"},
	   {"China", ".cn"}
	 };
	}
	
	//use dataprovider1 and pass the value as String s
	@Test(dataProvider="countryprovider")
	public void mytest1(String s) {
		System.out.println("now testing: "+ s);		
	}
	
	//use dataprovider2 and pass two parameters as Strings site and s
	@Test(dataProvider="urlprovider")
	public void mytest2(String country, String s) {
		System.out.println("URL of " + country + ": " + "http://www.element34" + s);
	}
}
