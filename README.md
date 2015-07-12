# seleniumtraining

## To start remote selenium server
- put IEDriverServer.exe into the same directory as selenium-server-standalone-2.46.0.jar
- from terminal window start sever as follows: java -jar selenium-server-standalone-2.46.0.jar -Dwebdriver.ie.driver=IEDriverServer.exe


## Grid startup
- Node: java -jar selenium-server-standalone-2.46.0.jar -role wd -nodeConfig "C:\Users\Michael Palotas\Desktop\seleniumtraining\nodeconfigs\nodeConfigWinIEFirefox.json" -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe
