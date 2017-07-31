# AXA Selenium training requirements

- Eclipse oder IntelliJ
- Maven 
- Firefox und Chrome latest 
- Projekt auschecken: https://github.com/palotas/e34seleniumtraining.git

1.
- Gehen Sie zur Datei: <IHR_FILESYSTEM>\e34seleniumtraining\src\test\java\seleniumbasics\BasicTests.java
- passen Sie den Pfad in der @BeforeTest Methode unter "Windows 7" oder "Windows 10" entsprechend der tatsächlichen Location des chromedrivers und geckodrivers an
- Führen Sie die Methode "firstChromeTest()" aus. Es sollte sich ein Chrome Browser öffnen und zur Element34 Webseite navigieren   


2. 
- In einem Terminal gehen Sie in das Verzeichnis: <IHR_FILESYSTEM>\IdeaProjects\e34seleniumtraining\resources
- Starten Sie den standalone Server durch das Kommando: `java - jar selenium-server-standalone-3.4.0.jar`
- Gehen Sie zur Datei: <IHR_FILESYSTEM>\e34seleniumtraining\src\test\java\remoteWebdriver\RemoteWebdriverTests.java
- Führen Sie die Methode "remoteWebdriverChromeTest()" aus. Dies sollte ebenfalls einen Chrome Browser öffnen und zur Element34 Webseite navigieren 
