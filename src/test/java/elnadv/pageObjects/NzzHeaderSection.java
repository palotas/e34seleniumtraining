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
public class NzzHeaderSection {


    @FindBy(css = "#nav-collapse > div > nav > ul > li:nth-child(1) > a")
    private WebElement angeboteLink;

    @FindBy(css = "#nav-collapse > div > nav > ul > li:nth-child(2) > a")
    private WebElement faqLink;

    @FindBy(css = "#nav-collapse > div > nav > ul > li:nth-child(3) > a")
    private WebElement kontaktLink;



    public NzzHeaderSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAngebote() {
        angeboteLink.click();
    }

    public void clickFAQ() {
        faqLink.click();
    }

    public void clickKontakt() {
        kontaktLink.click();
    }

}
