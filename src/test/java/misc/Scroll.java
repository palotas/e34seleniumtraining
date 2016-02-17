package misc;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Scroll {

	
	@Test
	public void scroll() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://gridfusion.net");
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
	@Test(invocationCount=1)
	public void explicitWait() throws InterruptedException, FileNotFoundException, IOException {
		//WebDriver driver=new FirefoxDriver();
		
		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();
		
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
}
