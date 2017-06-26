package htmlElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleRadioButton {
	
	@Test
	public void radioButtonTest() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();
		
		try {
			driver.get("http://element34.net/testpage");
			
			WebElement radioButtonsForm = driver.findElement(By.id("radiobuttons"));
			
			//check how many there are
			List<WebElement> radioButtons = radioButtonsForm.findElements(By.tagName("input"));
			Assert.assertEquals(radioButtons.size(), 3);
			
			//check if they are the correct entries
			List<String> expectedEntries = new ArrayList<String>();
			expectedEntries.add("male");
			expectedEntries.add("female");
			expectedEntries.add("other");

			int x = 0;
			
			for (WebElement radioButton : radioButtons) {
				Assert.assertEquals(radioButton.getAttribute("value"),  expectedEntries.get(x));
				System.out.println("Button text: " + radioButton.getAttribute("value"));
				x++;
			}
			
			WebElement myRadioButton = driver.findElement(By.id("other"));
			myRadioButton.click();
			
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}

}
