package htmlElementSamples;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleCheckBoxes {

		
	@Test
	public void checkboxTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			WebElement checkBoxForm = driver.findElement(By.id("checkboxform"));
			
			//check how many checkboxes there are
			List<WebElement> checkBoxes = checkBoxForm.findElements(By.tagName("input"));
			Assert.assertEquals(3, checkBoxes.size());
			
			//Check if Salami (checkbox 1) is checked. If yes uncheck it
			Thread.sleep(2000);
			WebElement checkBox = checkBoxes.get(0);
			if(checkBox.getAttribute("checked").contentEquals("true")) {
				checkBox.click();				
			}
		
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}

}
