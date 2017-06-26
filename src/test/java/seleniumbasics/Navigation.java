package seleniumbasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigation {

	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");

		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}
	

	@Test
	public void navigate() throws InterruptedException, FileNotFoundException, IOException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
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



