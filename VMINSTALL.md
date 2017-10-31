IMPORTANT: even if prompted, please DO NOT run any updates (i.e. browsers) on the VM. 

# Download the virtual machine
- Download the virtual machine from: 
- Note: the file is 6GB large so depending on your internet connection it may take a while 

# Install Virtual Box and import VM 
-  Install Virtual Box on your laptop (Download from: https://www.virtualbox.org/wiki/Downloads) 
-  Import downloaded VM (ova file) into Virtual Box( File -> Import Appliance )
-  Adapt VM settings (i.e. RAM, CPU). If possible the VM should have 2+ GB in RAM and 2 CPU cores) 
-  Start VM in Virtual Box (password: will be sent separately)
-  After VM has started, open Firefox or Chrome and make sure that VM has connection to the internet 


# Get latest code
- In the VM, open a terminal 
- type in: cd workspace/seleniumtraining
- type in: 'git pull'
- you should either have pulled the latest code or received a message that everything is already up to date 
( a few days before the workshop we will ask you to pull the latest code again as we are still doing some modifications to it )


# Run sample tests to ensure functionality 
-  Start IntelliJ (Icon is in the left pane on the bottom) (it may take a few minutes for IntelliJ to complete because it usually indexes all the files) 
-  The project "Seleniumtraining" should automatically be loaded 
-  Go to src -> test -> java -> seleniumbasics -> BasicTests.java 
-  Right-Click on the method firstChromeTest and select "Run firstChromeTest()"
-  A Chrome browser with the Google website should be opened

-  Open a terminal 
-  type in "cd Downloads"
-  type in "java -jar selenium-server-standalone-x.y.z.jar"
-  Selenium server should start 
-  In the IntelliJ project go to src -> test -> java -> remoteWebdriver -> RemoteWebdriverTests.java
-  Right-click on the method remoteWebdriverChromeTest() and select "Run remoteWebdriverChromeTest()"
-  Chrome should start and open the Google homepage

  
 You’re all set if those steps worked for you! 
