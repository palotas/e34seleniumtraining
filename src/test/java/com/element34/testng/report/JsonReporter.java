package com.element34.testng.report;

import com.element34.testng.multiplexer.Metadata;
import com.google.gson.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.JSONObject;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class JsonReporter implements IReporter {


  private final static String reportjs = "data.js";

  public JsonReporter() {

  }

  @Override
  public void generateReport(List<XmlSuite> list, List<ISuite> suites, String output) {

    JSONObject report = new JSONObject();
    report.put("date", new Date());
    JsonArray array = new JsonArray();
    for (ISuite suite : suites) {
      String name = suite.getName();
      Map<String, ISuiteResult> results = suite.getResults();
      for (String key : results.keySet()) {
        JsonObject o = new SuiteReporter(name, results.get(key)).generate().getJsonSuite();
        array.add(o);
      }
    }
    report.put("suites", array);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(report);

    write("var result = " + json);
  }


  class SuiteReporter {

    private final ISuiteResult results;
    private final String name;
    private final JsonObject res = new JsonObject();
    private final List<ITestNGMethod> methods;

    public SuiteReporter(String name, ISuiteResult results) {
      this.results = results;
      this.name = name;
      this.methods = Arrays.asList(results.getTestContext().getAllTestMethods());
    }

    public SuiteReporter generate() {
      res.addProperty("Name", name);
      long duration = results.getTestContext().getEndDate().getTime() - results.getTestContext().getStartDate().getTime();
      res.addProperty("TimeMillis", duration);
      // PassedTests
      processTests(res, "PassedTests", results.getTestContext().getPassedTests());
      // FailedTests
      processTests(res, "FailedTests", results.getTestContext().getFailedTests());
      // SkippedTests
      processTests(res, "SkippedTests", results.getTestContext().getSkippedTests());
      return this;
    }

    private JsonArray getParams(Object[] params) {

      JsonArray array = new JsonArray();
      for (Object param : params) {
        array.add(new JsonPrimitive(param.toString()));
      }
      return array;

    }

    private void processTests(JsonObject res, String type, IResultMap tests) {

      JsonArray array = new JsonArray();
      for (ITestNGMethod method : methods) {
        Set<ITestResult> results = tests.getResults(method);
        for (ITestResult result : results) {
          JsonObject r = new JsonObject();
          r.addProperty("Uuid", UUID.randomUUID().toString());
          r.addProperty("Test", method.getXmlTest().getName());
          r.addProperty("TimeMillis", result.getEndMillis() - result.getStartMillis());
          r.addProperty("Type", result.getMethod().getConstructorOrMethod().getMethod().getDeclaringClass().getCanonicalName());
          r.addProperty("MethodName", result.getMethod().getConstructorOrMethod().getMethod().getName());
          r.add("Parameters", getParams(result.getParameters()));
          r.addProperty("Status", result.getStatus());

          Metadata metadata = Metadata.getMetadata(result.getMethod());
          r.add("Metadata", metadata.asJson());

          if (result.getThrowable() != null) {
            JsonObject error = new JsonObject();
            error.addProperty("Message", result.getThrowable().getMessage());
            error.addProperty("Type", result.getThrowable().getClass().getName());
            error.addProperty("Stacktrace", ExceptionUtils.getStackTrace(result.getThrowable()));
            r.add("Error", error);
          }

          JsonArray logs = new JsonArray();

          List<String> outs = Reporter.getOutput(result);
          for (String out : outs) {
            // is it a special log ?
            Gson gson = new Gson();
            try {
              Map<String, String> log = gson.fromJson(out, Map.class);
              JsonObject o = new JsonObject();
              for (String key : log.keySet()) {
                o.addProperty(key, log.get(key).toString());
              }
              logs.add(o);
            } catch (Exception e) {
              JsonObject log = new JsonObject();
              log.addProperty("Type", "Log");
              log.addProperty("Message", out);
              logs.add(log);
            }


          }
          r.add("Logs", logs);
          array.add(r);
        }
      }

      res.add(type, array);
    }

    public JsonObject getJsonSuite() {
      return res;
    }


  }

  public void write(String content) {
    try {
      File f = new File(reportjs);
      PrintWriter writer = new PrintWriter(f);
      System.out.println("report : " + f.getAbsoluteFile());
      writer.write(content);
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}

