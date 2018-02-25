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


public class AxaPage2 {

    @FindBy(id="fl_zubehoer_content")
    private WebElement zubehoer;

    @FindBy(css="#fl_besonderes_kontrollschild_option > label:nth-child(2)")
    private WebElement besKontrollschildJa;

    @FindBy(css="#fl_besonderes_kontrollschild_option > label:nth-child(4)")
    private WebElement besKontrollschildNein;

    @FindBy(css="#fl_leasing_option > label:nth-child(2)")
    private WebElement leasingJa;

    @FindBy(css="#fl_leasing_option > label:nth-child(4)")
    private WebElement leasingNein;

    @FindBy(id="fl_kilometer_jahr")
    private WebElement kilometers;

    @FindBy(id="fl_kaufjahr")
    private WebElement kaufjahr;

    @FindBy(css="#fl_parkschaden_option > label:nth-child(2)")
    private WebElement parkschadenJa;

    @FindBy(css="#fl_parkschaden_option > label:nth-child(4)")
    private WebElement parkschadenNein;

    @FindBy(css="#fl_notbremsassistenten_option > label:nth-child(2)")
    private WebElement notbremsassistentJa;

    @FindBy(css="#fl_notbremsassistenten_option > label:nth-child(4)")
    private WebElement notbremsassistentNein;

    @FindBy(id="fl_auto_hff_geburtsdatum")
    private WebElement geburtsdatum;

    @FindBy(id="fl_hff_nationaliatet")
    private WebElement nationalitaet;

    @FindBy(id="fl_hff_plz")
    private WebElement plz;

    @FindBy(css="#fl_hff_geschlecht_option > label:nth-child(2)")
    private WebElement geschlechtMann;

    @FindBy(css="#fl_hff_geschlecht_option > label:nth-child(4)")
    private WebElement geschlechtFrau;

    @FindBy(css="#fl_hff_fuehrerausweisentzug_option > label:nth-child(2)")
    private WebElement entzugJa;

    @FindBy(css="#fl_hff_fuehrerausweisentzug_option > label:nth-child(4)")
    private WebElement entzugNein;

    @FindBy(css="#fl_hff_vorversicherer_option > label:nth-child(2)")
    private WebElement bisherigerVersichererJa;

    @FindBy(css="#fl_hff_vorversicherer_option > label:nth-child(4)")
    private WebElement bisherigerVersichererNein;

    @FindBy(id="fl_hff_vorversicherer_name")
    private WebElement versicherer;

    @FindBy(css="#fl_hff_vorversicherer_kuendigung_option > label:nth-child(2)")
    private WebElement kuendigungJa;

    @FindBy(css="#fl_hff_vorversicherer_kuendigung_option > label:nth-child(4)")
    private WebElement kuendigungNein;

    @FindBy(css="#fl_hff_schaeden5jahre_option > label:nth-child(2)")
    private WebElement schadenJa;

    @FindBy(css="#fl_hff_schaeden5jahre_option > label:nth-child(4)")
    private WebElement schadenNein;

    @FindBy(id="angaben_weiter")
    private WebElement weiterbutton;

    public AxaPage2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setZubehoer(String data_zusatzausruestung) throws InterruptedException {
        Thread.sleep(1000);
        //zubehoer.sendKeys(data_zusatzausruestung);
    }

    public void setKontrollschild(String data_kontrollschild) throws InterruptedException {
        Thread.sleep(1000);
        switch (data_kontrollschild) {
            case "JA" :
                besKontrollschildJa.click();
                break;

            case "NEIN" :
                besKontrollschildNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void setLeasing(String data_leasing) throws InterruptedException {
        Thread.sleep(1000);
        switch (data_leasing) {
            case "JA" :
                leasingJa.click();
                break;

            case "NEIN" :
                leasingNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void enterKilometer(String data_kilometer) {

        kilometers.sendKeys(data_kilometer);
    }

    public void selectPurchaseYear(String data_Year) throws InterruptedException {

        Thread.sleep(500);
        Select realSelect = new Select(kaufjahr);
        realSelect.selectByVisibleText(data_Year);
    }

    public void setParkschaden(String data_parkschaden) throws InterruptedException {
        Thread.sleep(2000);
        switch (data_parkschaden) {
            case "JA" :
                parkschadenJa.click();
                break;

            case "NEIN" :
                parkschadenNein.click();
                break;

            default:
                break;
        }
    }

    public void setNotbremsassistent(String data_notbrems) throws InterruptedException {
        Thread.sleep(1000);
        switch (data_notbrems) {
            case "JA" :
                notbremsassistentJa.click();
                break;

            case "NEIN" :
                notbremsassistentNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void setGebDatum(String data_gebDatum) {
        geburtsdatum.sendKeys(data_gebDatum);
    }

    public void selectNationality(String data_nationality) throws InterruptedException {

        Thread.sleep(1000);
        Select realSelect = new Select(nationalitaet);
        realSelect.selectByVisibleText(data_nationality);
    }

    public void enterPLZ(String data_plz) throws InterruptedException {
        Thread.sleep(1000);
        plz.sendKeys(data_plz);
    }

    public void setGeschlecht(String data_geschlecht) throws InterruptedException {
        Thread.sleep(1000);
        switch (data_geschlecht) {
            case "Mann" :
                geschlechtMann.click();
                break;

            case "Frau" :
                geschlechtFrau.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void setEntzug(String data_entzug) throws InterruptedException {

        Thread.sleep(1000);
        switch (data_entzug) {
            case "ja" :
                entzugJa.click();
                break;

            case "nein" :
                entzugNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }


    public void setBisherigerVersicherer(String data_bisherigerVersicherer, String data_versicherer) throws InterruptedException {

        Thread.sleep(1000);
        switch (data_bisherigerVersicherer) {
            case "ja" :
                bisherigerVersichererJa.click();
                Thread.sleep(500);

                Select realSelect = new Select(versicherer);
                realSelect.selectByVisibleText(data_versicherer);
                break;

            case "nein" :
                bisherigerVersichererNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void setKuendigung(String data_kuendigung) throws InterruptedException {

        Thread.sleep(2000);
        switch (data_kuendigung) {
            case "ja" :
                kuendigungJa.click();
                break;

            case "nein" :
                kuendigungNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void setSchaden(String data_schaden) throws InterruptedException {

        Thread.sleep(1000);
        switch (data_schaden) {
            case "ja" :
                schadenJa.click();
                break;

            case "nein" :
                schadenNein.click();
                break;

            default:
                System.out.println("your case does not exist");
        }
    }

    public void clickWeiter() {
        weiterbutton.click();
    }
}
