# ELN Selenium Advanced Training Agenda


Tag 1:

8.30 - 9.30: Recap des Selenium Basic Trainings (ELN)
9.30 - 10.00: Verwendung von Chrome Developer Tools für das Finden von Elementen
10.30 - 12.00: Page Objects (simple + advanced with embedded page object)
13.00 - 14.00: Test Framework Features (JUnit, TestNG) in Verbindung mit Selenium Tests
14.00 - 15.00: Reporting & Logging
Emailable Report: 
- add generateSuiteSummaryReport:     m_out.print("<b>DIGICOMP REPORT</b><img src=\"..//..//screenshots//digicomp.png\" ");
- show JSON report 
- Logging 
- screenshots (Helpers.java)
15.30 - 16.00: JavaScript und Selenium 
- scroll
- highlight
 
16.00 - 17.00: Action Builder / Advanced interactions API  
- drag & drop 
- iFrame



Tag 2:

8.30 - 8.45: Recap des letzten Tages 
8.45 - 9.30: Event Firing Webdriver / Interception
9.30 - 10.00: Listener Mechanismen in Verbindung mit Selenium 
10.30 - 11.00: Responsive Websites und Selenium
11.00 - 11.15: Geolocation Tests
11.15 - 11.30: Browsermob: SLOW external 
11.30 - 11.45: Browsermob: Slow network
11.45 - 12.00: Context Menu 
13.00 - 14.00: Selenium mit Docker
14.00 - 15.00: Skalierung und kurze Feedback Zyklen mit Selenium Grid
               Auswahlkriterien für Selenium Grid 
15.30 - 16.00: Mobile Testing mit Selenium
16.00 - 17.00: Your time, Selenium in der Zukunft






8.30 - 9.15: 
- Recap Selenium basic training 
- finding element with the JS console: 
 -> document.getElementsByName('btnK')
 -> document.querySelector('input[name="btnK"]')


# 9.15 - 10.00 + 10.20  - 11.00 
## Extend from BaseTest 
- extend from Basetest (page Object tests do not extend from there yet)
- without BaseTest all tests need to set the driver path somehow 
- show "BaseTest": set paths and execute it before each test suite @BeforeSuite
- extend PageObject test from BaseTest and remove section where paths are set 

## Page Objects with sections
- show tweet from simon about what page objects are
- show regular page object first 
- create header and login section
- build overall page with sections (NzzLoginPageWithSections)
- run test (NzzTestwithSections)

### 2. Enhance page object 
- enhance the page object test by checking if the password mismatch class is present -> isElementPresent (in Helpers.java)

### 3. Click FAQ Page / titleIs() expected condition 
- write test to click on FAQ page and check if you landed on https://abo.nzz.ch/faq
-> wait.until(Expectedconditions.titleIs() ) required   

### 4. time permitting
Interface Page Objects 

### 5. Expected exception / negative test 
- how to test that something is NOT on the page 
- go to google.com
- check that no element with ID abc is on the page (ExpectedException NoSuchelement.class)
- test should pass after that 

## Skip test 
- write a test that takes the browser version as parameter 
- add functionality to skip testsbased on a browser version 

  
## Reporting & Logging 
Emailable Report: 
- add generateSuiteSummaryReport:     m_out.print("<b>DIGICOMP REPORT</b><img src=\"..//..//screenshots//digicomp.png\" ");

- show JSON report 
- Logging 
- screenshots (Helpers.java)

## Highlight element before click 
- Highlight.java -> how can you visualize where your click will be  

## Event Firing / Intercepting 
- what can you do to intercept calls before after a webdriver command is executed? 
- implement WebDriverEventListener
- add system out in some of the methods 
- measure time it takes to find an element  
- wire highlight() into beforeClick() -> element are highlighted before each click 

## Listeners - Take screenshot upon test failure 
- create new listener by implementing ITestListener interface 
- implement to measure time how long a test took 

- add functionality to take screenshot when test fails 
--> driver is not accessible from listener by default 
- implement BaseTestWithDriver class 
- extend Test class from that class 
- webDriver() has access to driver and is thread safe 
--> driver is now accessible in listener 

## Data Providers for multi browser testing
- building data providers for multi browser testing  


MISC: 
- execute javascript (scroll) 
- Page Objects with interfaces 
- Action builder: drag & drop 
- Browser dimension 