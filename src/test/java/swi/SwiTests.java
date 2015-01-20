package swi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwiTests {
	
	
	@DataProvider(name = "environments")
	public Object[][] createDesiredCapabilities() {
	 return new Object[][] {
	   {DesiredCapabilities.firefox()},
	   {DesiredCapabilities.chrome()}
	 };
	}
	
	@Test (dataProvider = "environments")
	public void searchForDavos(DesiredCapabilities caps) throws InterruptedException, MalformedURLException {
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.get("http://www.swissinfo.ch");
		
		
		WebElement searchField = driver.findElement(By.name("query"));
		searchField.sendKeys("Davos");
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();
		
	}

	
	@Test (dataProvider = "environments")
	public void verifyMenu(DesiredCapabilities caps) throws InterruptedException, MalformedURLException {
		
		int index = 0;
		
		List<String> expectedMenuEntries = new ArrayList<String>();
		expectedMenuEntries.add("front page");
		expectedMenuEntries.add("latest news");
		expectedMenuEntries.add("politics");
		expectedMenuEntries.add("foreign affairs");
		expectedMenuEntries.add("business");
		expectedMenuEntries.add("culture");
		expectedMenuEntries.add("society");
		expectedMenuEntries.add("sci & tech");
		expectedMenuEntries.add("multimedia");
		expectedMenuEntries.add("in depth");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		
		try {
			driver.get("http://www.swissinfo.ch");
			
			WebElement menuBar = driver.findElement(By.className("topicsList"));
			List<WebElement> menuEntries = menuBar.findElements(By.className("clickFinger"));
			Assert.assertEquals(10, menuEntries.size());
			System.out.println("Number of menu entries: " + menuEntries.size());
			
			for (WebElement menuEntry : menuEntries) {
				Assert.assertEquals(expectedMenuEntries.get(index), menuEntry.getText().toLowerCase());
				System.out.println("Linktext: " + menuEntry.getText());
				index++;
			}			
		}
		finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
