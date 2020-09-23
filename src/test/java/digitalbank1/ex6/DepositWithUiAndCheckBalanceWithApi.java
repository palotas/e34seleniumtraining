/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1.ex6;

import digitalbank1.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepositWithUiAndCheckBalanceWithApi {

    @BeforeTest
    public void setup() {
        String OS = System.getProperty("os.name");
        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/workspace/e34seleniumtraining/resources/linux/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/workspace/e34seleniumtraining/resources/linux/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            case "Windows 7":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\Downloads\\geckodriver");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\Downloads\\chromedriver.exe");
                break;

            case "Windows 10":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\IdeaProjects\\e34seleniumtraining\\resources\\win10\\geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\micha\\IdeaProjects\\e34seleniumtraining\\resources\\win10\\chromedriver.exe");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }


    @BeforeMethod
    public void createUserAndAccountAndMakeDeposit() {
        Util util = new Util();
        util.createUser("rbi1@test.com");
        util.createAccountAndMake10KInitialDeposit();
    }

    @Test()
    public void withdraw5kFromCheckingAccountandCheck5KBalanceWithAPI() throws InterruptedException {

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

            driver.findElement(By.id("amount")).sendKeys("5000");
            driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

            //verify balance
            new Util().getCheckingAccountsAndVerify5KBalance();
        }


        finally {
            new Util().deleteUser("rbi1@test.com");

            if (driver!=null) {
                driver.quit();
            }

        }

    }
}
