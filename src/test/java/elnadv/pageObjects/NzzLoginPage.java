/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzLoginPage {

    NzzHeaderSection headerSection;
    NzzLoginSection loginSection;

    public NzzLoginPage(WebDriver driver) {

        this.headerSection = new NzzHeaderSection(driver);
        this.loginSection = new NzzLoginSection(driver);
        driver.get("https://login.nzz.ch");
        PageFactory.initElements(driver, this);
    }


    public void enterUsername() {
        loginSection.enterLoginName("hello@world.ch");
        loginSection.enterLoginPass();
    }




}
