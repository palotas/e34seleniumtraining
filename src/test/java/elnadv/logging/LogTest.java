package elnadv.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.EmailableReporter2;

import static net.logstash.logback.argument.StructuredArguments.keyValue;


/**
 * You can use you favorite log framework + testNG and still have good reports by
 * creating a testNG Appender.
 * See {@link TestNGAppender} : the code
 * See logback.xml : the wiring.
 *
 * Connecting Emelable report to see how the logs are displayed in a default testNG report.
 */
@Listeners(EmailableReporter2.class)
public class LogTest {


  @BeforeSuite
  public void setup(ITestContext context) {
    //context.getCurrentXmlTest().setParallel(ParallelMode.METHODS);
  }

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void test1() {
    Reporter.log("Hello from test1");
    System.out.println("sout from test1");
  }


  @Test
  public void test2() {
    Reporter.log("Hello from test2");
    System.out.println("sout from test2");

  }

  @Test
  public void test3() {
     logger.debug("debug from test4");
     logger.info("Hello from test4");
     logger.warn("warn from test4 {} ",keyValue("result","bla"));
     logger.error("huge error happened");
  }
}





