/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package testng;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProviderTest extends BaseTest {
	
	@Test(dataProvider="data", dataProviderClass = ReadExcel.class)
	public void mytest1(String data_year, String data_month, String data_marke, String data_model) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.axa.ch/ei/mf_main.seam?LINKID=1000&language=01&nzrv=x1z#s=MF_FAHRZEUG_LENKER");
		Thread.sleep(1000);

		Select year = new Select(driver.findElement(By.id("fl_erstinverkehrssetzung_shortcut_year")));
		year.selectByVisibleText(data_year);

		Select month = new Select(driver.findElement(By.id("fl_erstinverkehrssetzung_shortcut_month")));
		month.selectByVisibleText(data_month);

		Thread.sleep(1000);
		Select marke = new Select(driver.findElement(By.id("fl_marke")));
		marke.selectByVisibleText(data_marke);

		Thread.sleep(1000);
		WebElement treibstoff = driver.findElement(By.cssSelector("#fl_fuel_type > label:nth-child(2)"));
		treibstoff.click();

		Thread.sleep(1000);
		Select model = new Select(driver.findElement(By.id("fl_model")));
		model.selectByVisibleText(data_model);

		Thread.sleep(1000);
		WebElement schaltung = driver.findElement(By.cssSelector("#fl_transmission_type > label:nth-child(2)"));
		schaltung.click();

		Thread.sleep(1000);
		WebElement ps = driver.findElement(By.cssSelector("#fl_power > label:nth-child(2)"));
		ps.click();

		driver.findElement(By.id("fl_fzSuchen")).click();


		Thread.sleep(3000);
		driver.quit();
	}

}
