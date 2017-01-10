package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ShadowDom {


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
	public void firefoxPolymerShadowDom() throws FileNotFoundException, IOException {

		WebDriver driver = new ChromeDriver();

		System.out.println("Open Online Shop");
		driver.get("https://shop.polymer-project.org/");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		By byMenu = By.linkText("Ladies Outerwear");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byMenu));
		driver.findElement(byMenu).click();

		//Validate Page title
		By byHeading = By.cssSelector("header>h1");
		wait.until(ExpectedConditions.presenceOfElementLocated(byHeading));

		String getActualHeaderText = driver.findElement(byHeading).getText();
		Assert.assertEquals(getActualHeaderText, "Ladies Outerwear");

		driver.quit();

	}


	@Test
	public void chromePolymerShadowDom() throws FileNotFoundException, IOException, InterruptedException {


		WebDriver driver = new ChromeDriver();
		//DesiredCapabilities caps = DesiredCapabilities.chrome();
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.manage().window().maximize();

		driver.get("https://shop.polymer-project.org/");
		WebElement root1 = driver.findElement(By.tagName("shop-app"));
		Thread.sleep(2000);

		//Get shadow root element
		WebElement shadowRoot1 = expandRootElement(driver, root1);
		Thread.sleep(2000);
		WebElement appheader = shadowRoot1.findElement(By.id("header"));
		List<WebElement> shoptabs = appheader.findElements(By.tagName("shop-tab"));
		System.out.println(shoptabs.size());
		WebElement shoptab2 = shoptabs.get(1);
		System.out.println(shoptab2.getText());

		driver.quit();
	}

	@Test
	public void chromeDownloadsShadowDom() throws FileNotFoundException, IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		System.out.println("Open Chrome downloads");
		driver.get("chrome://downloads/");

		System.out.println("Validate downloads page header text");
		WebElement root1 = driver.findElement(By.tagName("downloads-manager"));

		//Get shadow root element
		WebElement shadowRoot1 = expandRootElement(driver, root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
		WebElement shadowRoot2 = expandRootElement(driver, root2);

		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		WebElement shadowRoot3 = expandRootElement(driver, root3);

		String actualHeading = shadowRoot3.findElement(By.cssSelector("div[id=leftContent]>h1")).getText();
		// Verify header title
		Assert.assertEquals("Downloads", actualHeading);

	}




	//Returns webelement
	public WebElement expandRootElement(WebDriver driver, WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}
	
}

