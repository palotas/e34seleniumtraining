/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package htmlElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SampleRadioButton {
	
	@Test
	public void radioButtonTest() throws InterruptedException, FileNotFoundException, IOException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

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
