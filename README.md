# seleniumtraining 

## To start remote selenium server
- put IEDriverServer.exe into the same directory as selenium-server-standalone-3.4.0.jar
- from terminal window start sever as follows: java -jar selenium-server-standalone-3.4.0.jar -Dwebdriver.ie.driver=IEDriverServer.exe


## Grid startup
- Node: java -jar selenium-server-standalone-3.4.0.jar -role wd -nodeConfig "C:\Users\Michael Palotas\Desktop\seleniumtraining\nodeconfigs\nodeConfigWinIEFirefox.json" -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe

## Standalone Chrome and Firefox
- $ docker run -d -p 4444:4444 selenium/standalone-chrome
- $ docker run -d -p 4444:4444 selenium/standalone-firefox

## VNC 
- $ docker run -d -p 4444:4444 -p 5900:5900 selenium/standalone-chrome-debug
- $ docker run -d -p 4444:4444 -p 5901:5900 selenium/standalone-firefox-debug
Start VNC viewer:
- $ vncviewer localhost:5900



## Selenium Grid 
Start Grid Hub: 
- $ docker run -d -p 4444:4444 --name selenium-hub selenium/hub
Register node:
- $ docker run -d --link selenium-hub:hub selenium/node-chrome
- $ docker run -d --link selenium-hub:hub selenium/node-firefox

## Stop / remove docker containers
- Kill all docker containers: ```docker kill $(docker ps -q)```
- Remove all docker containers: ```docker rm $(docker ps -a -q)```

## Start Grid with json config
java -jar selenium-server-standalone-3.4.0.jar -role hub -hubConfig ~/Workspace/Seleniumtraining/nodeconfigs/hubConfig.json
java -jar selenium-server-standalone-3.4.0.jar -role node -nodeConfig ~/Workspace/Seleniumtraining/nodeconfigs/nodeConfig.json


https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
