/*
 * Copyright (c) 2014 - 2019.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

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
                System.setProperty("webdriver.gecko.driver","C:\\Users\\micha\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\micha\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }

    @Test
    public void userCanLoginByUsername() throws MalformedURLException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverRunner.setWebDriver(driver);
        open("https://login.nzz.ch");
        $("#userAccountID").setValue("palotas@gmail.com");
        Thread.sleep(2000);
        $(By.name("checkUserAccount")).click();
        //Thread.sleep(2000);
        $("#c1-password-field").should(Condition.exist);
        driver.quit();

    }

    @Test
    public void loadDynamicPage() throws MalformedURLException, InterruptedException {

        Configuration.timeout=10000;
        WebDriver driver = new ChromeDriver();

        WebDriverRunner.setWebDriver(driver);
        open("https://the-internet.herokuapp.com/dynamic_loading/2");
        $("button").click();
        //$(By.id("finish")).shouldBe(Condition.appear);
        $(By.id("finish")).shouldHave(Condition.text(("Hello World!")));
        driver.quit();

    }

    @Test
    public void testpage() {
        Configuration.timeout=10000;
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);

        open("https://element34.com/testpage");
        $(By.id("male")).click();
        $(By.id("male")).shouldHave(Condition.selected);

        driver.quit();

    }

    @Test
    public void countRadioButtonsWithSelenide() {
        Configuration.timeout=10000;
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);

        open("https://element34.com/testpage");
        System.out.println($$(By.cssSelector("input[type='checkbox']")).size());

        driver.quit();

    }

    @Test
    public void countRadioPlainSelenium() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://element34.com/testpage");
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.quit();

    }
}
