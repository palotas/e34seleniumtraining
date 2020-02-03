
## Open browser
curl -XPOST http://localhost:9515/session -d '{"desiredCapabilities":{"browserName":"chrome"}}'


## Navigate to page
curl http://localhost:9515/session/$sessionId/url -d '{"url":"https://www.bmw.de"}'


## Close browser
curl -XDELETE http://localhost:9515/session/$sessionId

