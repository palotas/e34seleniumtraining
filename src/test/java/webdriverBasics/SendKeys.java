package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendKeys {

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
	public void sendKeysTest() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.abraxas.ch");

		WebElement searchBox = driver.findElement(By.id("searchField"));
		searchBox.sendKeys("Java");

		WebElement button = driver.findElement(By.className("searchButton"));
		button.click();
		
		Thread.sleep(5000);

		driver.quit();

	}
}
