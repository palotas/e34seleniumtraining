package com.element34.testng.multiplexer;


import elnadv.report.JsonReporter;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite.ParallelMode;

/**
 * Auto starting RemoteWebDriver when seeing the @WebTest annotation : see {@link WebTestListener}
 * Multiplexing test to all the requested browsers : Browsers=[browser1,browser2]
 * Reporting the result as json : see {@link JsonReporter}
 */
@Listeners({Multiplexer.class, WebTestListener.class,JsonReporter.class})
public class ExampleTest {

  @BeforeSuite
  public void parallel(ITestContext context) {
    context.getCurrentXmlTest().setParallel(ParallelMode.METHODS);
  }



  @Test
  public void metadata(){
    System.out.println(WebTestListener.metadata().asJson());
  }



  @DataProvider(name = "cred")
  public Object[][] login(){
    return  new Object[][]{
        {new User("user1")},
        {new User("user2")},
    };
  }

  @Test(dataProvider = "cred",invocationCount = 20,threadPoolSize = 20)
  @WebTest(browsers = Browsers.Web)
  public void simple(User user) throws InterruptedException {
    System.out.println("I'm "+user);
  }
}
