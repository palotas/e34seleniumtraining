package gwtSamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DatePicker {
	
	@Test
	public void selectDate() throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		
		//if this is commented out, the input field cannot be found
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwDatePicker");
		
		//option 1
		/*
		WebElement datePickerTextBox=driver.findElement(By.className("gwt-DateBox"));
		datePickerTextBox.click();	
		WebElement cell=driver.findElement(By.xpath("/html/body/div[5]/div/table/tbody/tr[2]/td/table/tbody/tr[7]/td[3]/div"));
		cell.click();
		*/
		
		//option 2
		WebElement datePickerTextBox=driver.findElement(By.className("gwt-DateBox"));
		datePickerTextBox.click();
		
		Thread.sleep(2000);
		
		WebElement datePicker=driver.findElement(By.xpath("/html/body/div[5]/div/table/tbody/tr[2]/td/table/tbody"));
		List<WebElement>rows=datePicker.findElements(By.tagName("tr"));
		System.out.println("Rows: " + rows.size());
		WebElement row7=rows.get(6);
		
		List<WebElement> cells=row7.findElements(By.tagName("td"));
		WebElement cell31=cells.get(2);
		WebElement div=cell31.findElement(By.tagName("div"));
		div.click();
		
		Thread.sleep(5000);
		
	}
	

}
