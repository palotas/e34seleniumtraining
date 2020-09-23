/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UITests {

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

    @Test(invocationCount = 1)
    public void createCheckingAccountAndDeposit5K() throws InterruptedException {
        Util prep = new Util();
        WebDriver driver = null;

        try {
            prep.createUser("rbi1@test.com");


            driver = new ChromeDriver();
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
            prep.deleteUser("rbi1@test.com");

            if (driver!=null) {
                driver.quit();
            }

        }



    }

    @Test
    public void withdraw1kFromCheckingAccountandCheck4KBalance() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/bank/login");
        driver.findElement(By.id("username")).sendKeys("rbi1@test.com");
        driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
        driver.findElement(By.id("submit")).click();

        driver.get("http://localhost:8080/bank/account/withdraw");
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
