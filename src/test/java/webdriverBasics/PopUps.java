package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopUps {

	@Test
	public void popUp() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();
		driver.get("http://gridfusion.net/popuptest.html");
		
		WebElement registerButton = driver.findElement(By.id("registerbutton"));
		registerButton.click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.quit();		
	}
	


}
