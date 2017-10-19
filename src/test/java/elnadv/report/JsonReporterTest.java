/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.report;

import elnadv.report.JsonReporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * using the reporter that produces json.
 */
@Listeners(JsonReporter.class)
public class JsonReporterTest {

  @Test
  public void test(){}
}
