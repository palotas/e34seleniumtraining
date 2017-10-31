/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.eventfiring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.sql.Time;

import static elnadv.Helpers.highlight;

/**
 * Created by e34 on 13/10/2017.
 */
public class MyEventListener implements WebDriverEventListener{

    private long startTime;
    private long endTime;

    public MyEventListener(RemoteWebDriver driver) {
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("beforeNavigateTo");

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("afterNavigateTo");

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

        endTime = System.currentTimeMillis() - startTime;
        System.out.println("findElement() took: " + endTime + " ms");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

        System.out.println("about to click on an element");
        //highlight(webDriver, webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("something went wrong. exception caught: " + throwable.getMessage());
    }
}
