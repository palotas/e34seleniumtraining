/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration {

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

        }
        finally {
            if(driver!=null) {
                driver.quit();
            }
        }
    }
}
