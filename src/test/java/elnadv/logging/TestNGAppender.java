/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.gson.Gson;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;


public class TestNGAppender extends AppenderBase<ILoggingEvent> {

  private final Gson gson = new Gson();

  @Override
  protected void append(ILoggingEvent log) {

    ITestResult currentResult = Reporter.getCurrentTestResult();
    if (currentResult != null) {
      Map<String, Object> map = new HashMap<>();
      map.put("level", log.getLevel().levelStr);
      map.put("msg", log.getMessage());
      String json = gson.toJson(map);
      Reporter.log(json);
    }
  }
}
