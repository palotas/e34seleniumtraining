package com.element34.testng.multiplexer;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.UUID;

/**
 * Logic to start browsers when a test is annotated with @WebTest
 */
public class WebTestListener implements IInvokedMethodListener2 {

  private static final InheritableThreadLocal<Metadata> metadataLocal = new InheritableThreadLocal<Metadata>();


  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    Metadata metadata = Metadata.getMetadata(method);
    if (metadata.get("browser") == null) {
      metadata.put("browser", "chrome");
      metadata.put("ran", UUID.randomUUID().toString());
    }
    metadataLocal.set(metadata);

    if (getAnnotation(method) != null) {
      String browser = (String) metadata.get("browser");
      metadata.put("driver", "create : " + browser + " driver for " + method.getTestMethod().getMethodName()+"()");
      // RemoteWebDriver driver = ...
    }

  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    if (getAnnotation(method) != null) {
      Metadata metadata = Metadata.getMetadata(method);
      System.out.println("stop driver : " + metadata.get("driver"));
    }
  }

  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

  }

  public static Metadata metadata() {
    return metadataLocal.get();
  }

  private WebTest getAnnotation(IInvokedMethod method) {
    return method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(WebTest.class);
  }
}
