package htmlElementSamples;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleDropDown {
	
	@Test
	public void dropdownTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			Select dropdown = new Select(driver.findElement(By.id("dropdown")));
			dropdown.selectByVisibleText("Mercedes");
			
			//check how many entries are in dropdown
			List<WebElement> options = dropdown.getOptions();
			Assert.assertEquals(4, options.size());
			
			//check if they are the correct entries
			List<String> expectedEntries = new ArrayList<String>();
			expectedEntries.add("Volvo");
			expectedEntries.add("Saab");
			expectedEntries.add("Mercedes");
			expectedEntries.add("Audi");
			int x = 0;
			
			for (WebElement option : options) {
				Assert.assertEquals(expectedEntries.get(x), option.getText());
				x++;
			}	
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
	}
}

