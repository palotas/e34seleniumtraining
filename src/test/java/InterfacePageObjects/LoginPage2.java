/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package InterfacePageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage2 extends LoginPageBase implements LoginPageInterface {


    public LoginPage2(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUserName(String username) {

        userid.sendKeys(username);
        try {
            Thread.sleep(2000);
            System.out.println("entering the username: " + username);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userid.clear();
        userid.sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {

        pass.clear();
        pass.sendKeys(password);

    }

    @Override
    public void clickLoginButton() {

        signinButton.click();
    }
}
