/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package InterfacePageObjects;

import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 20/09/15.
 */
public class LoginTest extends BaseTest {

    @Test
    public void loginTest1() {

        WebDriver driver = new FirefoxDriver();
        LoginPage1 mypage = new LoginPage1(driver);

        mypage.enterUserName("gridfusion");
        mypage.enterPassword("");
        mypage.clickLoginButton();
    }

    @Test
    public void loginTest2() {

        WebDriver driver = new FirefoxDriver();
        LoginPage2 mypage = new LoginPage2(driver);

        mypage.enterUserName("gridfusion");
        mypage.enterPassword("");
        mypage.clickLoginButton();
    }


}
