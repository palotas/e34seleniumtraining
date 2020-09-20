/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage1 {

    @FindBy(xpath="/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")
    private WebElement signUpHereLink;

    @FindBy(id="firstName")
    private WebElement firstName;

    @FindBy(id="lastName")
    private WebElement lastName;

    @FindBy(xpath="//*[@id=\"gender\"]")
    private WebElement gender;

    @FindBy(id="dob")
    private WebElement dateOfBirth;

    @FindBy(id="ssn")
    private WebElement ssn;

    @FindBy(id="emailAddress")
    private WebElement emailAddress;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath="/html/body/div[1]/div/div/div[2]/form/button")
    private WebElement nextButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/span[2]")
    private WebElement errorMessage;


    public RegistrationPage1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadRegistrationPage1(WebDriver driver) {
        driver.get("http://localhost:8080/bank");
    }

    public void clickSignUpHereLink() {
        signUpHereLink.click();
    }

    public void selectTitle(WebDriver driver) {
        Select title = new Select(driver.findElement(By.id("title")));
        title.selectByVisibleText("Mr.");
    }

    public void enterFirstName() throws InterruptedException {
        Thread.sleep(500);
        firstName.sendKeys("Joe");
    }

    public void enterLastName() throws InterruptedException {
        Thread.sleep(500);
        lastName.sendKeys("Smith");
    }

    public void selectGender() {
        gender.click();
    }

    public void enterDob() {
        dateOfBirth.sendKeys("08/28/1972");
    }

    public void enterSsn() {
        ssn.sendKeys("124-65-1245");
    }

    public void enterEmailAddress() {
        emailAddress.sendKeys("joesmith@test.com");
    }

    public void enterPassword() {
        password.sendKeys("MyPa$$word123");
    }

    public void enterConfirmPassword() {
        confirmPassword.sendKeys("MyPa$$word123");
    }

    public void clickNext() {
        nextButton.click();
    }

    public String getErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(errorMessage.getText());
        return errorMessage.getText();
    }

}
