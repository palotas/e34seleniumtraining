/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.pageObjects.standard;

import elnadv.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static elnadv.Helpers.isElementPresent;

/**
 * Created by gridfusion on 07/05/16.
 */
public class NzzTestWithSections extends BaseTest {

//    @BeforeTest
//    public void setup() {
//        String OS = System.getProperty("os.name");
//
//        switch (OS) {
//            case "Linux":
//                System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
//                System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
//                break;
//
//            case "Mac OS X":
//                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
//                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
//                break;
//
//            case "Windows 10":
//                System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
//                break;
//
//            default:
//                System.out.println(System.getProperty("os.name") + " is not supported ");
//                break;
//        }
//    }

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            NzzLoginPageWithSections loginPage = new NzzLoginPageWithSections(driver);
            loginPage.getLoginPage();
            loginPage.loginSection.enterLoginName("hello@world.ch");
            loginPage.loginSection.enterLoginPass();
            loginPage.loginSection.clickAnmeldenButton();
            Assert.assertTrue(isElementPresent(driver, By.className("message-password-mismatch")), "<<Element could not be found>>");
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void clickFAQLink() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            NzzLoginPageWithSections loginPage = new NzzLoginPageWithSections(driver);
            loginPage.headerSection.clickFAQ();
            //wait.until(ExpectedConditions.titleIs("FAQ - abo.nzz.ch"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://abo.nzz.ch/faq/");
        }
        finally {
            driver.quit();
        }

    }

}