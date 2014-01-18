package reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		BufferedWriter out = null;
		FileWriter fstream = null;			

		try {
			fstream = new FileWriter("/home/gridfusion/report.html");
			out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			  out.write("<html><head>" +
			  		"<LINK href='/home/gridfusion/SeleniumTraining/Workspace/selenium/src/test/java/reporting/style.css' rel='stylesheet' type='text/css'>" + 
			  		"</head><body>");
			  out.write("<b>ABRAXAS SELENIUM REPORT</b>");
			  
			  for(ISuite suite : suites) {
				  String suiteName = suite.getName();
					try {
						
						out.write("<div id='logo'><img src='/home/gridfusion/abraxaslogo.png' alt='logo'></div>");

						out.write("<div id='suitename'>" + "Suitename: " + suiteName + "</div>");
						Collection<IInvokedMethod> allMethods = suite.getAllInvokedMethods();

						Map<String, ISuiteResult> suiteResults = suite.getResults();
						out.write("<div id='suiteinfo'>");
						out.write("<div id='numbersuitesexecuted'>Number of Suites executed: " + suiteResults.size() + "</div>");	
						out.write("<div id='numbermethodsexecuted'>Number of methods executed: " + allMethods.size() + "</div>");
						out.write("</div>");
						
					
					     Map<String, ISuiteResult> r = suite.getResults();
					      for (ISuiteResult r2 : r.values()) {
					        ITestContext testContext = r2.getTestContext();
					        String testName = testContext.getName();
					        
					        out.write("<div id='starttime'>" + "Start time: " + testContext.getStartDate().toString() + "</div>");
					        out.write("<div id='endtime'>" + "End time: " + testContext.getEndDate().toString() + "</div>");
					        out.write("<div id='testname'>" +"Test name: " + testName + "</div>" );	
					        
					        out.write("<div id='numberpassedtests'>Passed tests: " + testContext.getPassedTests().getAllMethods().size() + "</div>");
					        Set<ITestResult> passedTests=testContext.getPassedTests().getAllResults();
					        for(ITestResult passedTest : passedTests) {
					        	out.write("<div id='passedtestblock'>");
					        	out.write("<div class='passedtest'>Test Method: " + passedTest.getName() + "</div>");
				        		out.write("<div id='output'>Logs: ");
					        	for(String output : Reporter.getOutput(passedTest)) {
					        		out.write("<div class='outputline'>" + output + "</div>");
					        	}
				        		out.write("</div></div></br>");					        						   
					        }
					        
					        out.write("<div id='numberfailedtests'>Failed tests: " + testContext.getFailedTests().getAllMethods().size() + "</div>");
					        Set<ITestResult> failedTests=testContext.getFailedTests().getAllResults();
					        for(ITestResult failedTest : failedTests) {
					        	out.write("<div id='failedtestblock'>");
					        	out.write("<div class='failedtest'>Test Method: " + failedTest.getName() + "</div>");

				        		out.write("<div id='output'>Logs: ");
					        	for(String output : Reporter.getOutput(failedTest)) {
					        		out.write("<div class='outputline'>" + output + "</div>");
					        	}
				        		out.write("</div></div></br>");					        						   
					        }
					      }
					}//try
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					finally{
						out.write("</body></html>");
						out.close();
					}

			  }//for
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			
		}
	}//method	
	
} //class

		
	

						


			  	
	
