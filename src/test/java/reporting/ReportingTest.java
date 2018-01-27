/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package reporting;


import elnadv.report.EmailReport;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ReportingTest {

	@Test
	public void simpleReportingTest() {
		
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);	
	}

	
	@Test
	public void reportingTestWithMessage() {
		Reporter.log("starting the test");
		int a = 1;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==3);
		Reporter.log("This is some " + "<b>bold</b> " + "and " + "<i>italic</i>" + " text");
		Reporter.log("ending the test");
	}
	
}
