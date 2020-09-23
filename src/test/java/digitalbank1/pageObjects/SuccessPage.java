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

public class SuccessPage {

    @FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/span[2]")
    private WebElement message;

     public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getMessage() {
        System.out.println(message.getText());
        return message.getText();
    }

}
