/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class HistoryReporter implements IReporter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @Override
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    // jenkins_job_id
    // authhor
    // stats.
    //Stat stat = new Stat();
    //logger.info("",keyValue("run_id",stat));
  }
}
