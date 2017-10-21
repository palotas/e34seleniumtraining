/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package sbox;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.SkipException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static sbox.Settings.HUB;
import static sbox.Settings.SCREENSHOT_DIRECTORY;

public class Helpers {

    public final static String[] CHROME_VERSIONS = {"58", "59", "60","61"};
    public final static String[] CHROME_SKIP_VERSIONS = {"58"};

    public static Object[][] getAllChromes() {
        Object[][] objects = new Object[(CHROME_VERSIONS.length)][];
        for (int i = 0; i < CHROME_VERSIONS.length; i++) {
            objects[i] = new Object[]{CHROME_VERSIONS[i]};
        }
        return objects;
    }

    public static void checkChromeVersionToSkip(String version) {
        List<String> versionList = new ArrayList<>();
        for (int i = 0; i < CHROME_SKIP_VERSIONS.length; i++) {
            versionList.add(CHROME_SKIP_VERSIONS[i]);
        }

        if (versionList.contains(version)) {
            throw new SkipException("unsupported Chrome Version for this feature");
        }
    }

    public static ExpectedCondition<Boolean> FileToBePresent(String... files) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (!(driver instanceof RemoteWebDriver)) {
                    throw new RuntimeException("Cannot only use FileToBePresent on a remote webdriver");
                } else {
                    try {
                        get(HUB +  "/e34/api/downloads?session=" + ((RemoteWebDriver) driver).getSessionId())

                                .then()
                                .body("name", hasItems(files));
                        return true;
                    } catch (Throwable t) {
                        return false;
                    }
                }
            }
        };
    }

    //not working due to conflic with restassured "size" element which gives back the size of the json array
    public static ExpectedCondition<Boolean> FileToBeSize(String... files) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (!(driver instanceof RemoteWebDriver)) {
                    throw new RuntimeException("Cannot only use FileToBePresent on a remote webdriver");
                } else {
                    try {
                        get(HUB +  "/e34/api/downloads?session=" + ((RemoteWebDriver) driver).getSessionId())

                                .then()
                                .body("size", is(307));
                        return true;
                    } catch (Throwable t) {
                        return false;
                    }
                }
            }
        };
    }

    public static String getDownloadedFileName(RemoteWebDriver driver){
        String fileName =
                get(HUB +"/e34/api/downloads?session=" + driver.getSessionId())
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("name")
                .replaceAll("[\\[\\](){}]","");
        System.out.println("Filename: " + fileName);
        return fileName;
    }

    public static String getInternalSessionId(RemoteWebDriver driver) {

        String internalSessionId =
                 get(HUB + "/e34/api/downloads?session=" + driver.getSessionId())
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("internalSessionId")
                .replaceAll("[\\[\\](){}]","");

        System.out.println("internal session ID: " + internalSessionId);
        return internalSessionId;

    }

    public static void screenshot(RemoteWebDriver driver) {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File ss = new File( SCREENSHOT_DIRECTORY + System.currentTimeMillis() +  ".png");
        tmp.renameTo(ss);
        System.out.println("Screenshot: " + ss.getAbsoluteFile());
    }
}
