/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbankdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UITests {

    private String email;




    @Test(invocationCount = 10, threadPoolSize = 10)
    public void allInOne() throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("e34:token", "b280dc6d-0d25-45");
        caps.setCapability("e34:l_testName",  "Digital Bank - Deposit / Withdrawal test " + caps.getBrowserName());

        WebDriver driver = new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), caps);

        Util prep = new Util();


        try {
            String email = prep.createEmailAddress();
            prep.createUser(email);

            driver.get("http://localhost:8080/bank/login");
            driver.findElement(By.id("username")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
            driver.findElement(By.id("submit")).click();
            driver.findElement(By.id("checking-menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("view-checking-menu-item")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"emptyAccounts\"]/div/div/div[3]/a/button")).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("Standard Checking")));
            driver.findElement(By.id("Standard Checking")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("Individual")).click();
            driver.findElement(By.id("name")).sendKeys("main checking account");
            driver.findElement(By.id("openingBalance")).sendKeys("5000");
            driver.findElement(By.id("newCheckingSubmit")).click();


            Thread.sleep(5000);
            driver.get("http://localhost:8080/bank/account/withdraw");
            Select accountSelector = new Select(driver.findElement(By.id("selectedAccount")));
            accountSelector.selectByVisibleText("main checking account (Standard Checking)");

            driver.findElement(By.id("amount")).sendKeys("1000");
            driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

            //verify balance
            Thread.sleep(3000); //wait for element to be visible
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div/div/form/div/div[7]")).getText(), "Balance: $4000.00");

            //driver.quit();
        }
        finally {
            if (driver!=null) {
                driver.quit();
            }
        }




    }



    @Test(invocationCount = 1)
    public void createCheckingAccountAndDeposit5K() throws InterruptedException, MalformedURLException {

        String environment = System.getenv("environment");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("e34:token", "b280dc6d-0d25-45");
        caps.setCapability("e34:l_testName",  "Digital Bank - Deposit / Withdrawal test " + caps.getBrowserName());

        System.out.println(environment);

        WebDriver driver = new RemoteWebDriver(new URL("https://"+ environment + "/wd/hub"), caps);

        Util prep = new Util();


        try {
            prep.createUser("rbi1@test.com");


            driver.get("http://localhost:8080/bank/login");
            driver.findElement(By.id("username")).sendKeys("rbi1@test.com");
            driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
            driver.findElement(By.id("submit")).click();
            driver.findElement(By.id("checking-menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("view-checking-menu-item")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"emptyAccounts\"]/div/div/div[3]/a/button")).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("Standard Checking")));
            driver.findElement(By.id("Standard Checking")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("Individual")).click();
            driver.findElement(By.id("name")).sendKeys("main checking account");
            driver.findElement(By.id("openingBalance")).sendKeys("5000");
            driver.findElement(By.id("newCheckingSubmit")).click();
        }
        finally {
            //prep.deleteUser("rbi1@test.com");

            if (driver!=null) {
                driver.quit();
            }

        }



    }

    @Test(dependsOnMethods = "createCheckingAccountAndDeposit5K")
    public void withdraw1kFromCheckingAccountandCheck4KBalance() throws InterruptedException, MalformedURLException {
        String environment = System.getenv("environment");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("e34:token", "b280dc6d-0d25-45");
        caps.setCapability("e34:l_testName",  "Digital Bank - Deposit / Withdrawal test " + caps.getBrowserName());

        System.out.println(environment);

        WebDriver driver = new RemoteWebDriver(new URL("https://"+ environment + "/wd/hub"), caps);
        driver.get("http://localhost:8080/bank/login");
        driver.findElement(By.id("username")).sendKeys("rbi1@test.com");
        driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
        driver.findElement(By.id("submit")).click();

        driver.get("http://localhost:8080/bank/account/withdraw");
        Thread.sleep(1000);
        Select accountSelector = new Select(driver.findElement(By.id("selectedAccount")));
        accountSelector.selectByVisibleText("main checking account (Standard Checking)");

        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

        //verify balance
        Thread.sleep(3000); //wait for element to be visible
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div/div/form/div/div[7]")).getText(), "Balance: $4000.00");

        driver.quit();

    }
}
