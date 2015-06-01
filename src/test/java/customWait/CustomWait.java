package customWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustomWait {

	
	@Test(invocationCount=1)
	public void implicitWaitHeroku() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		
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
	public void explicitWait() throws InterruptedException, FileNotFoundException, IOException {
		//WebDriver driver=new FirefoxDriver();
		
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		
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
