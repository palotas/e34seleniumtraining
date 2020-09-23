/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbankdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationTests {


    @Test(invocationCount = 3, threadPoolSize = 5)
    public void registerJoeSmithShortForm() throws InterruptedException, MalformedURLException {

        String environment = System.getenv("environment");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("e34:token", "b280dc6d-0d25-45");
        caps.setCapability("e34:l_testName",  "Digital Bank - Registration test " + caps.getBrowserName());

        System.out.println(environment);

        WebDriver driver = new RemoteWebDriver(new URL("https://"+ environment + "/wd/hub"), caps);

        RegistrationPage1 regPage1 = new RegistrationPage1(driver);
        RegistrationPage2 regPage2 = new RegistrationPage2(driver);
        SuccessPage successPage = new SuccessPage(driver);

        regPage1.fillRegistrationPage1(driver);
        successPage = regPage2.fillRegistrationPage2(driver);

        Assert.assertEquals(successPage.getMessage(), "Registration Successful. Please Login.");
        driver.quit();

        cleanup(regPage1.getEmailAddress());

    }



//    @AfterMethod
    public void cleanup(String email) {
        Util util = new Util();
        util.deleteUser(email);
    }
}
