#!/bin/bash

clear

#echo "Enter the IP address of the system: "
#read IPADDRESS
#echo "You entered IP address: $IPADDRESS"
IPADDRESS=192.168.1.114
echo "Your IP address is: $IPADDRESS"


cd "/home/gridfusion/tools"
echo "##############################################################"
echo "1. starting Selenium GRID hub on port 4444"
echo "##############################################################"
java -Dfile.encoding=UTF-8 -cp "ios-grid-plugin-0.6.6-SNAPSHOT-20140422-1408.jar:ios-server-standalone-0.6.6-SNAPSHOT-20140422-1408.jar:net.gridfusion-1.0-SNAPSHOT.jar:selendroid-grid-plugin-0.9.0.jar:selenium-server-standalone-2.41.0.jar" org.openqa.grid.selenium.GridLauncher -capabilityMatcher net.gridfusion.GridFusionMatcher -servlets net.gridfusion.GridFusionConsole -role hub -host $IPADDRESS -port 4444 &

#java -Dfile.encoding=UTF-8 -cp "ios-grid-plugin-0.6.6-SNAPSHOT-20140422-1408.jar:ios-server-standalone-0.6.6-SNAPSHOT-20140422-1408.jar:net.gridfusion-1.0-SNAPSHOT.jar:selenium-server-standalone-2.41.0.jar" org.openqa.grid.selenium.GridLauncher -capabilityMatcher net.gridfusion.GridFusionMatcher -servlets net.gridfusion.GridFusionConsole -role hub -host $IPADDRESS -port 4444 &

#java -jar selenium-server-standalone-2.41.0.jar -role hub -host $IPADDRESS -port 4444 &

#java -Dfile.encoding=UTF-8 -cp "selendroid-grid-plugin-0.9.0.jar:selenium-server-standalone-2.40.0.jar" org.openqa.grid.selenium.GridLauncher -capabilityMatcher io.selendroid.grid.SelendroidCapabilityMatcher -role hub -host $IPADDRESS -port 4444 &

#java -Dfile.encoding=UTF-8 -cp "ios-server-standalone-0.6.6-SNAPSHOT-20140416-1405.jar:ios-grid-plugin-0.6.6-SNAPSHOT-20140416-1405.jar:selendroid-grid-plugin-0.9.0.jar:selenium-server-standalone-2.41.0-multimobile.jar" org.openqa.grid.selenium.GridLauncher -capabilityMatcher org.uiautomation.ios.grid.IOSCapabilityMatcher,org.uiautomation.ios.grid.WebCapabilityMatcher,io.selendroid.grid.SelendroidCapabilityMatcher -role hub -host $IPADDRESS -port 4444 &

sleep 10




echo "#####################################################################"
echo "2. starting Selendroid Server with SELENDROID TEST APP on port 6666" 
echo "#####################################################################"
java -jar selendroid-standalone-0.9.0-with-dependencies.jar -app selendroid-test-app-0.9.0.apk -port 6666 &
###java -jar selendroid-standalone-0.9.0-with-dependencies.jar -app eBayMobile-2.4.0.15-debug.apk -port 6666 &
sleep 15



echo "##############################################################"
echo "3. starting Web Node on Port 7777" 
echo "##############################################################"
java -jar selenium-server-standalone-2.41.0.jar -role wd -host $IPADDRESS -port 7777 -hubHost $IPADDRESS -hubPort 4444 -nodeConfig web-nodes-config.json &
sleep 10 

#echo "##############################################################"
#echo "4. send registration request for web node to grid hub"
#echo "##############################################################"
#curl -H "Content-Type: application/json" -X POST --data @web-nodes-config.json http://$IPADDRESS:4444/grid/register &
#sleep 3

echo "##############################################################"
echo "5. send registration request for selendroid node to grid hub"
echo "##############################################################"
curl -H "Content-Type: application/json" -X POST --data @selendroid-nodes-config.json http://$IPADDRESS:4444/grid/register &






