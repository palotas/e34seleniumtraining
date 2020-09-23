/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage2 {

    @FindBy(id="address")
    private WebElement address;

    @FindBy(id="locality")
    private WebElement locality;

    @FindBy(id="region")
    private WebElement region;

    @FindBy(id="country")
    private WebElement country;

    @FindBy(id="postalCode")
    private WebElement postalCode;

    @FindBy(id="homePhone")
    private WebElement homePhone;

    @FindBy(id="mobilePhone")
    private WebElement mobilePhone;

    @FindBy(id="workPhone")
    private WebElement workPhone;

    @FindBy(id="agree-terms")
    private WebElement agreeTerms;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/button")
    private WebElement registerButton;

     public RegistrationPage2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterAddress() throws InterruptedException {
         Thread.sleep(500);
         address.sendKeys("Teichweg 8, 8853 Lachen");
    }

    public void enterLocality() throws InterruptedException {
        Thread.sleep(500);
        locality.sendKeys("space");
    }

    public void enterRegion() throws InterruptedException {
        Thread.sleep(500);
        region.sendKeys("SZ");
    }

    public void enterCountry() {
        country.sendKeys("Switzerland");
    }

    public void enterPostalCode() {
        postalCode.sendKeys("8853");
    }

    public void enterHomePhone() {
        homePhone.sendKeys("0796690708");
    }

    public void enterMobilePhone() {
        mobilePhone.sendKeys("0796690708");
    }

    public void enterWorkPhone() {
        workPhone.sendKeys("0796690708");
    }

    public void clickAgreeTerms() {
        agreeTerms.click();
    }

    public SuccessPage clickRegisterButton(WebDriver driver) {
        registerButton.click();
        return new SuccessPage(driver);
    }

    public SuccessPage fillRegistrationPage2(WebDriver driver) throws InterruptedException {
         enterAddress();
         enterLocality();
         enterRegion();
         enterCountry();
         enterPostalCode();
         enterHomePhone();
         enterMobilePhone();
         enterWorkPhone();
         clickAgreeTerms();
         return clickRegisterButton(driver);

    }

}
