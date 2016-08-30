package webdriverBasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Navigation {
	

	@Test
	public void navigate() throws InterruptedException, FileNotFoundException, IOException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.20min.ch/");
		
		WebElement link = driver.findElement(By.linkText("Schweiz"));
		link.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "20 Minuten - News von jetzt!");
		Thread.sleep(3000);
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "20 Minuten - Nachrichten");
		Thread.sleep(3000);
		driver.quit();		
	}
}



