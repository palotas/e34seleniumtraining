package seleniumTests;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Navigation {
	

	@Test
	public void navigate() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.20min.ch/");
		
		WebElement link = driver.findElement(By.linkText("Schweiz"));
		link.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Assert.assertEquals("20 Minuten - News von jetzt!", driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().forward();
		Assert.assertEquals("20 Minuten - Nachrichten", driver.getTitle());
		Thread.sleep(3000);
		driver.quit();		
	}
}



