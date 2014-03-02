Feature: Opening a browser a go to a URL
 
Scenario: Opening a firefox browser and go to a specified URL
Given I open a firefox browser
When I type http://www.ebay.com in the browser
When I type ipad in the search
When I hit search
Then the URL should be http://www.ebay.com