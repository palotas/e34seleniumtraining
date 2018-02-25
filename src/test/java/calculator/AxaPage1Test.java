/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package calculator;

import elnadv.BaseTest;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AxaPage1Test extends BaseTest {
	
	@Test(dataProvider="data", dataProviderClass = ReadExcel.class)
	public void mytest1(String data_year, String data_month, String data_marke, String data_model,
                        String data_schaltung, String data_treibstoff, String data_ps, String specificModel,
                        String data_zusatzausruestung, String data_besKontrollschild, String data_leasing,
                        String data_kilometer, String data_kaufjahr, String data_parkschaden, String data_notbrems,
                        String data_gebDatum, String data_nationalitaet, String data_plz, String data_geschlecht,
                        String data_entzug, String data_bisherigeVersicherer, String data_versicherer, String data_kuendigung,
                        String data_schaden5Jahre) throws InterruptedException, MalformedURLException {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("e34:token", "72aa4d82");
		capability.setCapability("e34:l_testName", "Selenium Test");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capability);
        //RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


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

		AxaPage2 page2 = new AxaPage2(driver);
		page2.setZubehoer(data_zusatzausruestung);
		page2.setKontrollschild(data_besKontrollschild);
		page2.setLeasing(data_leasing);
		page2.enterKilometer(data_kilometer);
		page2.selectPurchaseYear(data_kaufjahr);
		page2.setParkschaden(data_parkschaden);
		page2.setNotbremsassistent(data_notbrems);
		page2.setGebDatum(data_gebDatum);
		page2.selectNationality(data_nationalitaet);
		page2.enterPLZ(data_plz);
		page2.setGeschlecht(data_geschlecht);
		page2.setEntzug(data_entzug);
		page2.setBisherigerVersicherer(data_bisherigeVersicherer, data_versicherer);
		page2.setKuendigung(data_kuendigung);
		page2.setSchaden(data_schaden5Jahre);
		page2.clickWeiter();
		Thread.sleep(3000);
		driver.quit();
	}

}
