# Installation instructions for virtual machine 

IMPORTANT: even if asked, please DO NOT run any updates (i.e. browsers) on the VM. 

1. Install Virtual Box on the host machine 
2. Import .ova file into Virtual Box 
3. Adapt VM settings (i.e. RAM, CPU). If possible the VM should have 2+ GB in RAM and 2 CPU cores) 
4. Start VM in Virtual Box 
5. After VM has started, open Friefox or Chrome and make sure that VM has connection to the internet 
6. Start IntelliJ (Icon is in the left pane on the bottom) (it may take a few minutes for IntelliJ to complete because it usually indexes all the files) 
7. The project "Seleniumtraining" should automatically be loaded 
8. Go to src -> test -> java -> webdriverbasics -> BasicTests.java 
9. Right-Click on the method firstFirefoxTest and select "Run firstFirefoxTest()"
10.A Firefox browser with the Google website should be opened

11. Open a terminal 
12. type in "cd Downloads"
13. type in "java -jar selenium-server-standalone-3.4.0.jar"
14. Selenium server should start 
15. In IntelliJ go to src -> test -> java -> remoteWebdriver -> RemoteWebdriverTests.java
16. Right-click on the method remoteWebdriverFirefoxTest() and select "Run remoteWebdriverFirefoxTest()"
17. Again a Firefox should start and open the Google homepage 

