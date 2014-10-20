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

public class PostautoTests {
	
	
	@Test
	public void findElementTest() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		
		try{
			driver.get("http://www.postauto.ch");
			WebElement searchField=driver.findElement(By.id("query"));
			searchField.sendKeys("Grindelwald");
			
			WebElement button=driver.findElement(By.className("submit"));
			button.click();
			
			WebElement link=driver.findElement(By.linkText("Grosse Scheidegg Rundfahrt"));
		}
		finally{
			Thread.sleep(5000);
			driver.quit();
		}
		
		
	}
	
	
	
	
	
	

	@Test
	public void myFirstTest() throws InterruptedException, MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://cando:melius@postauto-test-web.cando-image.com/user");
		
		WebElement username = driver.findElement(By.id("edit-name"));
		WebElement password = driver.findElement(By.id("edit-pass"));
		WebElement loginButton = driver.findElement(By.id("edit-submit"));
		
		username.sendKeys("admin");
		password.sendKeys("admin");
		loginButton.click();
		
		driver.get("http://postauto-test-web.cando-image.com/en-adm/node/add/add-product");
		driver.get("http://postauto-test-web.cando-image.com/en-adm/node/add/product");
		
		Select dropdown = new Select(driver.findElement(By.id("edit-language")));
		List<WebElement> options = dropdown.getOptions();

		//check if correct number of entries exist 
		Assert.assertEquals(options.size(), 6);
		dropdown.selectByVisibleText("German");
		
		
		WebElement titleField = driver.findElement(By.id("edit-title-field-und-0-value"));
		titleField.sendKeys("my title");
		
		WebElement summaryField = driver.findElement(By.id("edit-field-summary-und-0-value"));
		summaryField.sendKeys("my summary");
		
		WebElement editor = driver.findElement(By.xpath("//*[@id='cke_contents_edit-body-und-0-value']/iframe"));
		editor.sendKeys("my edited text");
		
		WebElement button=driver.findElement(By.id("edit-field-product-und-actions-ief-add"));
		button.click();
		
		
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
