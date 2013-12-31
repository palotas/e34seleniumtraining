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
	public void implicitWaitTest() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		WebElement searchfield=driver.findElement(By.id("gbqfq"));
		searchfield.sendKeys("michael palotas");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
