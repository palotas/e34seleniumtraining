package wait;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CustomWait {

	
	@Test(invocationCount=1)
	public void implicitWaitHeroku() throws InterruptedException, IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		try {
			//first try without implicit wait
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

			driver.findElement(By.cssSelector("#start > button")).click();
			System.out.println(driver.findElement(By.cssSelector("#finish")).getText());			
		}
		finally {
			driver.quit();
		}
	}
	
	
	
	
	@Test(invocationCount=1)
	public void explicitWait() throws InterruptedException, IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
			
			driver.findElement(By.cssSelector("#start > button")).click();
			//first try without explicit wait
			//wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish"))));
			System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
		}
		finally {
			driver.quit();
		}
	}

	@Test
	public void fluentWait() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);




		driver.get("about:policy");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, SECONDS)
				.pollingEvery(5, SECONDS)
				//.ignoring(NoSuchElementException.class);
				.ignoring(StaleElementReferenceException.class);

		WebElement reload = wait.until(new Function<WebDriver, WebElement>()
		{

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("reload-policies"));
			}
		});


		reload = driver.findElement(By.id("reload-policies"));
		System.out.println(reload.getText());
		driver.get("about:policy");
		System.out.println(reload.getText());
		System.out.println(reload.getText());
		driver.quit();





	}
	// Waiting 30 seconds for an element to be present on the page, checking

	// for its presence once every 5 seconds.






}
