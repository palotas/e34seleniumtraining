#!/bin/bash

echo "Hello $USER, starting up the machines"
cd "/home/gridfusion/tools"
echo "1. starting Selenium GRID hub on port 4444"
java -jar selenium-server-standalone-2.40.0.jar -role hub




