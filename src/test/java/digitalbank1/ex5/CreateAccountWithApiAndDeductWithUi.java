/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1.ex5;

import digitalbank1.Util;
import digitalbank1.listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class CreateAccountWithApiAndDeductWithUi {

    @BeforeMethod
    public void createUserAndAccountAndMakeDeposit() {
        Util util = new Util();
        util.createUser("rbi1@test.com");
        util.createAccountAndMake10KInitialDeposit();

    }

    @Test()
    public void withdraw1kFromCheckingAccountandCheck4KBalance() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("http://localhost:8080/bank/login");
            driver.findElement(By.id("username")).sendKeys("rbi1@test.com");
            driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
            driver.findElement(By.id("submit")).click();

            Thread.sleep(2000);

            driver.get("http://localhost:8080/bank/account/withdraw");
            Select accountSelector = new Select(driver.findElement(By.id("selectedAccount")));
            accountSelector.selectByVisibleText("main checking account (Standard Checking)");

            driver.findElement(By.id("amount")).sendKeys("1000");
            driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

            //verify balance
            Thread.sleep(3000); //wait for element to be visible
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div/div/form/div/div[7]")).getText(), "Balance: $9000.00");
        }


        finally {
            new Util().deleteUser("rbi1@test.com");

            if (driver!=null) {
                driver.quit();
            }

        }

    }
}
