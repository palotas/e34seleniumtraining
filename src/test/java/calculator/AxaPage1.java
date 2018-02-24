/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AxaPage1 {

    @FindBy(id="fl_erstinverkehrssetzung_shortcut_year")
    private WebElement year;

    @FindBy(id="fl_erstinverkehrssetzung_shortcut_month")
    private WebElement month;

    @FindBy(id="fl_marke")
    private WebElement marke;

    @FindBy(css="#fl_fuel_type > label:nth-child(2)")
    private WebElement benzin;

    @FindBy(css="#fl_fuel_type > label:nth-child(4)")
    private WebElement diesel;

    @FindBy(css="#fl_fuel_type > label:nth-child(6)")
    private WebElement andere;

    @FindBy(id="fl_model")
    private WebElement model;

    @FindBy(css="#fl_transmission_type > label:nth-child(2)")
    private WebElement automat;

    @FindBy(css="#fl_transmission_type > label:nth-child(4)")
    private WebElement manuell;

    @FindBy(css="#fl_power > label:nth-child(2)")
    private WebElement ps100;

    @FindBy(css="#fl_power > label:nth-child(4)")
    private WebElement ps200;

    @FindBy(css="#fl_power > label:nth-child(6)")
    private WebElement ps200plus;

    @FindBy(css="#fl_power > label:nth-child(8)")
    private WebElement psWeissNicht;

    @FindBy(id="fl_fzSuchen")
    private WebElement fahrzeugSuchenButton;

    public AxaPage1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get(("https://secure.axa.ch/ei/mf_main.seam?LINKID=1000&language=01&nzrv=x1z#s=MF_FAHRZEUG_LENKER"));
    }

    public void selectYear(String dataYear) throws InterruptedException {

        Thread.sleep(500);
        Select realSelect = new Select(year);
        realSelect.selectByVisibleText(dataYear);
    }

    public void selectMonth(String dataMonth) throws InterruptedException {

        Thread.sleep(500);
        Select realSelect = new Select(month);
        realSelect.selectByVisibleText(dataMonth);
    }

    public void selectMarke(String dataMarke) throws InterruptedException {

        Thread.sleep(500);
        Select realSelect = new Select(marke);
        realSelect.selectByVisibleText(dataMarke);
        Thread.sleep(500);
    }


    public int returnIndex(WebDriver driver, String value) {
        List<WebElement> optionElements = driver.findElement(By.id("fl_model")).findElements(By.tagName("option"));
        String optionIndex = "";

        for (WebElement optionElement : optionElements) {
            if (optionElement.getText().contains(value)) {
                optionIndex = optionElement.getAttribute("index");
                break;
            }
        }
        return Integer.parseInt(optionIndex);
    }

    public void selectModell(WebDriver driver, String dataModel) throws InterruptedException {

        Thread.sleep(1000);

        int index  = returnIndex(driver, dataModel);
        Select realSelect = new Select(model);
        realSelect.selectByIndex(index);

        Thread.sleep(500);
    }

    public void selectTreibstoff(String dataTreibstoff) throws InterruptedException {

        switch (dataTreibstoff) {
            case "Benzin" :
                benzin.click();
                break;

            case "Diesel" :
                diesel.click();
                break;

            case "Andere" :
                diesel.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void selectSchaltung(String dataSchaltung) throws InterruptedException {

        switch (dataSchaltung) {
            case "Automat" :
                automat.click();
                break;

            case "Manuell" :
                manuell.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }


    public void selectPS(String dataPS) throws InterruptedException {

        switch (dataPS) {
            case "Bis 100" :
                ps100.click();
                break;

            case "101-200" :
                ps200.click();
                break;

            case "Mehr als 200" :
                ps200plus.click();
                break;

            case "Weiss nicht" :
                psWeissNicht.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void clickSearchButton() throws InterruptedException {
        fahrzeugSuchenButton.click();
    }


    public void selectSpecificModel(WebDriver driver, String specificModel) throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.className("table__item__info__content"));
        System.out.println(list.size() + " items found");

        System.out.println(list.get(0).getText());

        for (WebElement element : list) {
            if (element.getText().contains(specificModel)) {
                element.click();
                break;
            }
        }
    }

}
