/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank1.ex1;

import digitalbank1.listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class RegistrationPositive {


    @Test
    public void registerNewUser() throws InterruptedException {

        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.get("http://localhost:8080/bank");
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")).click();

            Select title = new Select(driver.findElement(By.id("title")));
            title.selectByVisibleText("Mr.");
            Thread.sleep(1000);

            driver.findElement(By.id("firstName")).sendKeys("Joe");
            driver.findElement(By.id("lastName")).sendKeys("Smith");
            driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();

            driver.findElement(By.id("dob")).sendKeys("08/28/1972");
            driver.findElement(By.id("ssn")).sendKeys("123-45-9999");
            driver.findElement(By.id("emailAddress")).sendKeys("joesmith@test.com");
            driver.findElement(By.id("password")).sendKeys("MyPa$$word123");
            driver.findElement(By.id("confirmPassword")).sendKeys("MyPa$$word123");
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click();

            //next page
            Thread.sleep(3000);
            driver.findElement(By.id("address")).sendKeys("Teichweg 8, 8853 Lachen");
            driver.findElement(By.id("locality")).sendKeys("space");
            driver.findElement(By.id("region")).sendKeys("ZH");
            driver.findElement(By.id("country")).sendKeys("Switzerland");
            driver.findElement(By.id("postalCode")).sendKeys("8853");
            driver.findElement(By.id("homePhone")).sendKeys("0796690708");
            driver.findElement(By.id("mobilePhone")).sendKeys("0796690708");
            driver.findElement(By.id("workPhone")).sendKeys("0796690708");
            driver.findElement(By.id("agree-terms")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click();

            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/span[2]")).getText(), "Registration Successful. Please Login.");

        }
        finally {
            if(driver!=null) {
                driver.quit();
            }
        }
    }
}