/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

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
 * Connecting Emailable report to see how the logs are displayed in a default testNG report.
 */
@Listeners(EmailableReporter2.class)
public class LogTest {


  @BeforeSuite
  public void setup(ITestContext context) {
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





