IMPORTANT: even if prompted, please DO NOT run any updates (i.e. browsers) on the VM. 

# Download the virtual machine
- Download the virtual machine from: https://element34.com/public/Training-Ubuntu18.04.ova 
- Note: the file is 12GB large so depending on your internet connection it may take a while 

# Install Virtual Box and import VM 
-  Install Virtual Box (5.2.x) on your laptop (Download from: https://www.virtualbox.org/wiki/Downloads) 
-  Import downloaded VM (ova file) into Virtual Box( File -> Import Appliance )
-  Adapt VM settings (i.e. RAM, CPU). If possible the VM should have 4+ GB in RAM and 2 CPU cores) 
-  Start VM in Virtual Box 
-  Log in with user: e34 password: 11 
-  After VM has started, open Firefox or Chrome and make sure that VM has connection to the internet 


# Get latest code
- In the VM, open a terminal 
- type in: cd workspace/e34seleniumtraining
- type in: 'git pull'
- you should either have pulled the latest code or received a message that everything is already up to date 


# Run sample tests to ensure functionality 
-  Start IntelliJ (Icon is in the left pane on the bottom) (it may take a few minutes for IntelliJ to complete because it usually indexes all the files) 
-  The project "Seleniumtraining" should automatically be loaded 
-  Go to src -> test -> java -> seleniumbasics -> BasicTests.java 
-  Right-Click on the method firstChromeTest and select "Run firstChromeTest()"
-  A Chrome browser with the Element34 homepage should be opened. The browser should close automatically. 

  
 You’re all set if those steps worked for you! 
