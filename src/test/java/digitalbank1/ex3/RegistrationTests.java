/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1.ex3;

import digitalbank1.Util;
import digitalbank1.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class RegistrationTests {

    @Test
    public void registerJoeSmithWhereUserDoesNotExistYet() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        RegistrationPage1 regPage1 = new RegistrationPage1(driver);
        regPage1.loadRegistrationPage1(driver);
        regPage1.clickSignUpHereLink();
        regPage1.selectTitle(driver);
        regPage1.enterFirstName();
        regPage1.enterLastName();
        regPage1.selectGender();
        regPage1.enterDob();
        regPage1.enterSsn();
        regPage1.enterEmailAddress();
        regPage1.enterPassword();
        regPage1.enterConfirmPassword();
        regPage1.clickNext();
        Thread.sleep(1000);

        RegistrationPage2 regPage2 = new RegistrationPage2(driver);
        regPage2.enterAddress();
        regPage2.enterLocality();
        regPage2.enterRegion();
        regPage2.enterPostalCode();
        regPage2.enterCountry();
        regPage2.enterHomePhone();
        regPage2.enterMobilePhone();
        regPage2.enterWorkPhone();
        regPage2.clickAgreeTerms();
        SuccessPage successPage = regPage2.clickRegisterButton(driver);

        Assert.assertEquals(successPage.getMessage(), "Registration Successful. Please Login.");

        driver.quit();
    }

    @Test(invocationCount = 1)
    public void registerJoeSmithShortForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        RegistrationPage1 regPage1 = new RegistrationPage1(driver);
        RegistrationPage2 regPage2 = new RegistrationPage2(driver);
        SuccessPage successPage = new SuccessPage(driver);

        regPage1.fillRegistrationPage1(driver);
        successPage = regPage2.fillRegistrationPage2(driver);

        Assert.assertEquals(successPage.getMessage(), "Registration Successful. Please Login.");
        driver.quit();
    }

    @Test
    public void registerJoeSmithWhereUserAlreadyExists() throws InterruptedException {

        Util util = new Util();
        util.createUser("joesmith@test.com");

        WebDriver driver = new ChromeDriver();
        RegistrationPage1 regPage1 = new RegistrationPage1(driver);
        regPage1.loadRegistrationPage1(driver);
        regPage1.clickSignUpHereLink();
        regPage1.selectTitle(driver);
        regPage1.enterFirstName();
        regPage1.enterLastName();
        regPage1.selectGender();
        regPage1.enterDob();
        regPage1.enterSsn();
        regPage1.enterEmailAddress();
        regPage1.enterPassword();
        regPage1.enterConfirmPassword();
        regPage1.clickNext();
        Thread.sleep(1000);
        Assert.assertEquals(regPage1.getErrorMessage(), "An account is already registered with the email address provided. Login with the existing account or provide another email address.");

        driver.quit();
    }




    @AfterMethod
    public void cleanup() throws InterruptedException {
        Util util = new Util();
        util.deleteUser("joesmith@test.com");
        System.out.println("cleanup done");
    }
}
