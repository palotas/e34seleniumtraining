/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NzzLoginPage {


    @FindBy(id="c2-login-field")
    private WebElement emailAddress;

    @FindBy(name = "checkUserAccount")
    private WebElement weiterButton;


    public NzzLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get(("https://login.nzz.ch"));
    }

    public void enterEmailAddress(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void clickWeiterButton() {
        weiterButton.click();
    }


    public void login(String email) {
        enterEmailAddress(email);
        clickWeiterButton();
    }








}
