/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzLoginSection {

    @FindBy(name="login")
    private WebElement loginName;

    @FindBy(name="password")
    private WebElement loginPass;

    @FindBy(className="btn")
    private WebElement button;

    @FindBy(name = "remember_me")
    private WebElement rememberCheckbox;


    public NzzLoginSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLoginName(String name) {
        loginName.sendKeys(name);
    }

    public void enterLoginPass() {
        loginPass.sendKeys("testpassword");
    }

    public void clickAnmeldenButton() {
        button.click();
    }

    public void clickRememberMe() {
        rememberCheckbox.click();
    }

}
