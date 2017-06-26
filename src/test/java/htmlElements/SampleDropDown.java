package htmlElements;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleDropDown {
	
	@Test
	public void dropdownTest() throws InterruptedException, FileNotFoundException, IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		try {
			driver.get("http://element34.net/testpage");
			
			Select dropdown = new Select(driver.findElement(By.id("dropdown")));
			dropdown.selectByVisibleText("Mercedes");
			
			//check how many entries are in dropdown
			List<WebElement> options = dropdown.getOptions();
			Assert.assertEquals(options.size(), 4);
			
			//check if they are the correct entries
			List<String> expectedEntries = new ArrayList<String>();
			expectedEntries.add("Volvo");
			expectedEntries.add("Saab");
			expectedEntries.add("Mercedes");
			expectedEntries.add("Audi");
			int x = 0;
			
			for (WebElement option : options) {
				Assert.assertEquals(option.getText(), expectedEntries.get(x));
				x++;
			}	
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
	}
}

