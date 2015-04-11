package cucumber;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class OpenSigninPageStepDefinitions {
	
	WebDriver driver;
	
    @Given("^I open a firefox browser$")
    public void I_want_to_open_a_firefox_browser() {
    	driver = new FirefoxDriver();
    }
    
    
    @When("^I type (.*) in the browser$")
    public void I_type_ebay_in_the_browser(String url) {
    	driver.get(url);
    }

    @When("^I type (.*) in the search$")
    public void I_type_something_in_search(String url) throws InterruptedException {
    	driver.findElement(By.id("gh-ac")).sendKeys(url);
    	Thread.sleep(2000);
    	//driver.get(url);
    }
    
    @When("^I hit search$")
    public void I_hit_search() throws InterruptedException {
    	driver.findElement(By.id("gh-btn")).click();
    	Thread.sleep(2000);
    }
    
    
    @Then("^the URL should be (.*)$")
    public void checkPage(String url) {
    	
    	try {
    		assertTrue("wrong URL: " + driver.getCurrentUrl(), driver.getCurrentUrl().contains(url));
    	}
    	finally {
        	driver.quit();    		
    	}
    }


}
