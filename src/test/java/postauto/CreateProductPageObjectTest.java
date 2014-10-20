package postauto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProductPageObjectTest {

	@Test
	public void createProductTest() throws InterruptedException, MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://cando:melius@postauto-test-web.cando-image.com/user");
		
		SigninPage signinPage=new SigninPage(driver);
		signinPage.enterUsername();
		signinPage.enterPassword();
		signinPage.clickLoginButton();

				
		driver.get("http://postauto-test-web.cando-image.com/en-adm/node/add/add-product");
		driver.get("http://postauto-test-web.cando-image.com/en-adm/node/add/product");
		
		Thread.sleep(5000);
		
		CreateProductPage cpPage=new CreateProductPage(driver);
		cpPage.enterTitle();
		cpPage.enterSummary();
		cpPage.enterEditor();
		
		
		// close the Browser
		Thread.sleep(3000);
		driver.quit();
	}

	
	@Test
	public void menuTest() throws InterruptedException, MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		WebDriver driver = new RemoteWebDriver(new URL("http://palotas:c69edf87-0701-41d3-8222-2268084734f1@ondemand.saucelabs.com:80/wd/hub"),capability);

		driver.get("http://cando:melius@postauto-test-web.cando-image.com/user");

		
		WebElement username = driver.findElement(By.id("edit-name"));
		WebElement password = driver.findElement(By.id("edit-pass"));
		WebElement loginButton = driver.findElement(By.id("edit-submit"));
		
		username.sendKeys("admin");
		password.sendKeys("admin");
		loginButton.click();
		

		//check menu
		WebElement menuBar=driver.findElement(By.id("admin-menu-menu"));
		List<WebElement>menuEntries=new ArrayList<WebElement>();
		menuEntries=menuBar.findElements(By.className("admin-menu-toolbar-category"));
		System.out.println("Number of links: " + menuEntries.size());
		
		
		// close the Browser
		Thread.sleep(3000);
		driver.quit();
	}
	
}
