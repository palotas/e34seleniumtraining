package HtmlElementSamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleRadioButton {
	
	@Test
	public void radioButtonTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			WebElement radioButtonsForm = driver.findElement(By.id("radiobuttons"));
			
			//check how many there are
			List<WebElement> radioButtons = radioButtonsForm.findElements(By.tagName("input"));
			Assert.assertEquals(5, radioButtons.size());
			
			//check if they are the correct entries
			List<String> expectedEntries = new ArrayList<String>();
			expectedEntries.add("katze");
			expectedEntries.add("hund");
			expectedEntries.add("loewe");
			expectedEntries.add("tiger");
			expectedEntries.add("vogel");
			int x = 0;
			
			for (WebElement radioButton : radioButtons) {
				Assert.assertEquals(expectedEntries.get(x), radioButton.getAttribute("value"));
				System.out.println("Button text: " + radioButton.getText());
				x++;
			}
			
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}
	
	
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
