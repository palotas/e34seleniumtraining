package gwtSamples;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverActions {
	
	@Test
	public void navigateMenu() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwMenuBar");

		WebElement fileMenu=driver.findElement(By.id("gwt-debug-cwMenuBar-item0"));
		fileMenu.click();
		Thread.sleep(2000);
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.id("gwt-debug-cwMenuBar-item0-item4"))).click().build().perform();
	    
	    Thread.sleep(2000);
	    driver.quit();

	}

}
