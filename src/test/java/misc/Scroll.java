package misc;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Scroll {

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
	public void scroll() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://www.element34.net");
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
	@Test(invocationCount=1)
	public void explicitWait() throws InterruptedException, FileNotFoundException, IOException {

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
}
