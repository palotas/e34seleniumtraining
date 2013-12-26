package gwtSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Radiobuttons {
	
	@Test
	public void countRadioButtons() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwRadioButton");
		
		List<WebElement> radioButtons=driver.findElements(By.className("gwt-RadioButton"));
		Assert.assertEquals(10, radioButtons.size());
				
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	@Test
	public void verifyButtonLabels() throws InterruptedException {
		
		//set up reference data
		List<String> refList=new ArrayList<String>(Arrays.asList("blue", "red", "yellow", "green", 
				"Baseball", "Basketball", "Football", "Hockey", "Soccer", "Water Polo"));

		int index=0;
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwRadioButton");
		
		List<WebElement> radioButtons=driver.findElements(By.className("gwt-RadioButton"));
		
		for(WebElement radioButton : radioButtons) {
			//System.out.println("Labels of radio buttons: " + radioButton.getText());
			Assert.assertEquals(refList.get(index), radioButton.getText());
			index++;
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
