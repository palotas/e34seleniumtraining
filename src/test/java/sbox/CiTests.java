/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static sbox.Settings.HUB;

@Listeners(StatusListenerSbox.class)
public class CiTests extends TestBaseThreadSafe {


    @Epic("Simple test")
    @Feature("positive test")
    @Story("Reporter logs should be visible in Allure report")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void simpleTest() throws IOException, InterruptedException {

        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        addVideoLink(driver);
        Reporter.log("hello world");
        Assert.assertEquals(1, 1);
    }


    @Epic("T-Mobile Demo")
    @Feature("positive test")
    @Story("Page title should be T-Mobile")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void ciDemo() throws IOException, InterruptedException {

        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        addVideoLink(driver);
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        driver.manage().window().maximize();


        for (int i= 0; i < 5; i++) {
            driver.get("https://t-mobile.com");
            Thread.sleep(1000);
            driver.get("https://google.com");
            Thread.sleep(1000);


        }

        Assert.assertEquals(driver.getTitle(), "Cell Phones | 4G Phones | iPhone and Android Phones | T-Mobile" );
        screen(driver);
    }


    @Epic("T-Mobile Demo")
    @Feature("different URLs can be opened")
    @Story("Dataprovider test")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "urls", dataProviderClass = TestData.class, invocationCount = 1, threadPoolSize = 100)
    public void loadTest(String url) throws IOException, InterruptedException {

        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        addVideoLink(driver);

        driver.manage().window().maximize();
        driver.get(url);
        System.out.println(driver.getTitle());
        Thread.sleep((long)(Math.random() * 20000));
    }


    @Epic("T-Mobile Demo")
    @Feature("failing a test")
    @Story("Tests should be able to fail")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void failedTest() throws IOException, InterruptedException {


        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        addVideoLink(driver);
        WebDriverWait wait =  new WebDriverWait(getDriver(), 10);
        getDriver().manage().window().maximize();


        driver.get("https://t-mobile.com");
        Assert.assertEquals(driver.getCurrentUrl(), "NASA" );
        Thread.sleep(5000);

    }



    private String printVideoURL(RemoteWebDriver driver) {
        return ("https://vm-105.element34.net/videos/" + driver.getSessionId() + ".mp4");
    }

    private void logVideoUrl(RemoteWebDriver driver) {
        Reporter.log("<a href=" + printVideoURL(driver) + ">Click here for a video of this test</a>");

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(RemoteWebDriver driver) {
        System.out.println("calling allure screenshot");
        return driver.getScreenshotAs(OutputType.BYTES);
    }

//    public void screenshot(RemoteWebDriver driver) {
//        File tmp = driver.getScreenshotAs(OutputType.FILE);
//        File ss = new File("" + System.currentTimeMillis() + ".png");
//        tmp.renameTo(ss);
//        System.out.println("Screenshot: " + ss.getAbsoluteFile());
//    }

    private void screen(RemoteWebDriver driver) {
        saveScreenshot((driver).getScreenshotAs(OutputType.BYTES));
    }


    @Attachment(value = "Video link", type = "text/css")
    public String printVideoLink(RemoteWebDriver driver) {
        return HUB + "/videos/" + driver.getSessionId() + ".mp4";
    }


    @Attachment
    public static String logOutput(List<String> outputList) {
        String output = "";
        for (String o : outputList)
            output += o + " ";
        return output;
    }

    private void addVideoLink(RemoteWebDriver driver) {
        io.qameta.allure.model.Link link = new io.qameta.allure.model.Link();
        link.setName("VIDEO URL");
        link.setUrl(HUB + "/videos/" + driver.getSessionId() + ".mp4");
        Allure.addLinks(link);
    }


}
