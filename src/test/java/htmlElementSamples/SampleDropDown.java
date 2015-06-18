package htmlElementSamples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleDropDown {
	
	@Test
	public void dropdownTest() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
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

