# Nashville CAST Agenda

## Introduction
- general automation intro 
- Selenium Toolset
- what is Selenium / what is it not? 

## Test Frameworks
- what to look for in a test framework 
- framework examples (JUnit / TestNG / MSTest )
- config: before / after  -> ConfigurationTest (--> where is the example with suite -> class -> test .... ? )
- groups 
- dependencies : package dependency > DependencyTest --> ```com.element34.testng.dependency.DependencyTest.login() is depending on method public void com.element34.testng.dependency.DependencyTest.dbUp(), which is not annotated with @Test or not included.
                                                         	at org.testng.internal.MethodHelper.findDependedUponMethods(MethodHelper.java:109)
                                                         	at org.testng.internal.MethodHelper.topologicalSort(MethodHelper.java:208)
                                                         	at org.testng.internal.MethodHelper.sortMethods(MethodHelper.java:284)
                                                         	at org.testng.internal.MethodHelper.collectAndOrderMethods(MethodHelper.java:57)
                                                         	at org.testng.TestRunner.initMethods(TestRunner.java:472)
                                                         	at org.testng.TestRunner.init(TestRunner.java:250)
                                                         	at org.testng.TestRunner.init(TestRunner.java:220)
                                                         	at org.testng.TestRunner.<init>(TestRunner.java:161)```



## Listeners
- package: listener
- first run without listener wired 
 

## Reporting / Logging 


## Wait Mechanisms 
- implicit wait 
- explicit wait 
- fluent wait 

## WebTest annotation 

## Page Objects 