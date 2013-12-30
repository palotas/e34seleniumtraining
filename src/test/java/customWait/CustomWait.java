package customWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class CustomWait {
	
	@Test
	public void explicitWaitTest() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver,10); 
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbqfq")));	
		WebElement searchfield=driver.findElement(By.id("gbqfq"));
		searchfield.sendKeys("michael palotas");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
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
