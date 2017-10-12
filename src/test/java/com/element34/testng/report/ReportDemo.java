package com.element34.testng.report;


import elnadv.report.JsonReporter;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class ReportDemo {


  public static XmlSuite createSuite(String name, Class... classes) {
    XmlSuite suite = new XmlSuite();
    suite.setName(name);

    suite.setThreadCount(10);
    suite.setParallel(ParallelMode.METHODS);


    for (int i = 0; i < 1; i++) {
      XmlTest test = new XmlTest(suite);
      test.setName("test_" + i);

      List<XmlClass> xmlClassList = new ArrayList<>();
      for (Class clazz : classes) {
        XmlClass testClass = new XmlClass();
        testClass.setName(clazz.getCanonicalName());
        xmlClassList.add(testClass);

      }
      test.setXmlClasses(xmlClassList);
    }
    // this is what the testNG.xml would look like :
    //System.out.println(suite.toXml());
    return suite;
  }


  public static void main(String[] args) {

    TestNG testng = new TestNG();

    List<XmlSuite> suites = new ArrayList<>();
    suites.add(createSuite("suite1", Simple.class/*, DataProviderTest.class*/));
    suites.add(createSuite("suite2", Simple.class, DataProviderTest.class));

    testng.setXmlSuites(suites);

    testng.setUseDefaultListeners(true);

    testng.addListener((ITestNGListener) new JsonReporter());
    testng.addListener((ITestNGListener) new LiveReport());

    testng.run();

  }
}
