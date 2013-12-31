package ajaxSamples;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AjaxSelectSample {
	
	@Test
	public void dropdownFields() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://samples.genexus.com/ajaxsample/client.aspx?INS,0");	
		
		WebElement first=driver.findElement(By.id("CLIENTFIRSTNAME"));
		WebElement last=driver.findElement(By.id("CLIENTLASTNAME"));
		
		WebElement select=driver.findElement(By.id("COUNTRYID"));
		//wrap webelement into Select helper
		Select dropdown=new Select(select); 
		//System.out.println("selected option: " + dropdown.getFirstSelectedOption().getText());
		
		first.sendKeys("michael");
		last.sendKeys("palotas");
		dropdown.selectByValue("430"); //value for "USA"
		
		//check if proper cities are are populated in the city field
		//first set up the expected data
		ArrayList<String>expectedCities=new ArrayList<String>();
		expectedCities.add("California");
		expectedCities.add("Chicago");
		expectedCities.add("Kansas");
		expectedCities.add("montevideo");
		expectedCities.add("New York");
		expectedCities.add("Washington");
		
		Select citydropdown=new Select(driver.findElement(By.id("CITYID"))); 
		ArrayList<String> options = new ArrayList<String>();

		for(WebElement element : citydropdown.getOptions()) {
			//System.out.println(element.getText());
			options.add(element.getText());
		}
		for(String s : options) {
			System.out.println(s);
		}
		//check if populated city list is as expected
		Assert.assertTrue(options.equals(expectedCities));
			
		Thread.sleep(5000);
		driver.quit();		
	}

}
