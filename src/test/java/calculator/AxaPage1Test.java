/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package calculator;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class AxaPage1Test extends BaseTest {
	
	@Test(dataProvider="data", dataProviderClass = ReadExcel.class)
	public void mytest1(String data_year, String data_month, String data_marke, String data_model, String data_schaltung, String data_treibstoff, String data_ps, String specificModel) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		AxaPage1 page1 = new AxaPage1(driver);
		page1.loadPage(driver);
		page1.selectYear(data_year);
		page1.selectMonth(data_month);
		page1.selectMarke(data_marke);
		page1.selectTreibstoff(data_treibstoff);
		page1.selectModell(driver, data_model);
		page1.selectSchaltung(data_schaltung);
		page1.selectPS(data_ps);
		page1.clickSearchButton();

		page1.selectSpecificModel(driver, specificModel);

		//Thread.sleep(3000);
		//driver.quit();
	}

}
