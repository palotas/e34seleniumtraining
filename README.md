docker run -d -p 4444:4444 --name chrome selenium/standalone-chrome:3.8.1-aluminum

docker run -d -p 4444:4444 --name firefox selenium/standalone-firefox:3.8.1-aluminum

docker run -d -p 4444:4444 -p 5900:5900 --name chrome-debug selenium/standalone-chrome-debug:3.8.1-aluminum

docker run -d -p 4444:4444 -p 5901:5900 --name firefox-debug selenium/standalone-firefox-debug:3.8.1-aluminum

sudo apt-get install xtightvncviewer

vncviewer localhost:5900
