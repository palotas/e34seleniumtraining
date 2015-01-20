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
	public void implicitWait() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		//first try without implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gridfusion.net/ajax.html");
		
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
		
		WebElement newDiv = driver.findElement(By.id("newdiv"));
		System.out.println(newDiv.getText());
		
		driver.quit();

	}
	
	
	
	@Test
	public void explicitWait() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		
		
		driver.get("http://gridfusion.net/ajax.html");
		
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
		
		//first try without explicit wait
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("newdiv"))));
		WebElement newDiv = driver.findElement(By.id("newdiv"));
		System.out.println(newDiv.getText());
		
		driver.quit();

	}
}
