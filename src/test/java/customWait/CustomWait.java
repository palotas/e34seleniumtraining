package customWait;

import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

	
	@Test(invocationCount=1)
	public void implicitWaitHeroku() throws InterruptedException, MalformedURLException {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		//first try without implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		
		driver.findElement(By.cssSelector("#start > button")).click();
		System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
		
		driver.quit();

	}
	
	
	
	
	@Test(invocationCount=1)
	public void explicitWait() throws InterruptedException, MalformedURLException {
		//WebDriver driver=new FirefoxDriver();
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		

		driver.findElement(By.cssSelector("#start > button")).click();
		//first try without explicit wait
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish"))));
		System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
		
		driver.quit();

	}
}
