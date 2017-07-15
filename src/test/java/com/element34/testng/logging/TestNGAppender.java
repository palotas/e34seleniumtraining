package com.element34.testng.logging;

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
