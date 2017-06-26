package htmlElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SampleCheckBoxes {

		
	@Test
	public void checkboxTest() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();
		
		try {
			driver.get("http://www.element34.net/testpage");
			
			WebElement checkBoxForm = driver.findElement(By.id("checkboxform"));
			
			//check how many checkboxes there are
			List<WebElement> checkBoxes = checkBoxForm.findElements(By.tagName("input"));
			Assert.assertEquals(checkBoxes.size(), 2);
			
			//Check if bike (checkbox 1) is checked. If yes uncheck it
			Thread.sleep(2000);
			WebElement checkBox = checkBoxes.get(0);
			
			if(checkBox.isSelected()) {
				checkBox.click();				
			}
		
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}

}
