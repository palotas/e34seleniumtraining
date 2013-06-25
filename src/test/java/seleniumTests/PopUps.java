package seleniumTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopUps {
	
	
	/*
	 * This test:
	 * - opens a Firefox browser and goes to http://gridfusion.net/popuptest.html
	 * - clicks on register button 
	 * - clicks on the OK button on the alert
	 * - closes the browser
	 */
	@Test
	public void popUp() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gridfusion.net/popuptest.html");
		
		WebElement registerButton = driver.findElement(By.id("registerbutton"));
		registerButton.click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.quit();		
	}
	


}
