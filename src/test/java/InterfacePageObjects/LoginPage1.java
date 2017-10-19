/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package InterfacePageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by gridfusion on 20/09/15.
 */
public class LoginPage1 extends LoginPageBase implements LoginPageInterface {


    public LoginPage1(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUserName(String username) {
        userid.sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {
        pass.sendKeys(password);

    }

    @Override
    public void clickLoginButton() {

        signinButton.click();
    }
}
