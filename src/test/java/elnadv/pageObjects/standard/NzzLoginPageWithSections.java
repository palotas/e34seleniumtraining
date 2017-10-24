/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.pageObjects.standard;

import org.openqa.selenium.WebDriver;

public class NzzLoginPageWithSections {

    NzzLoginSection loginSection;
    NzzHeaderSection headerSection;
    WebDriver driver;

    public NzzLoginPageWithSections(WebDriver driver) {
        this.driver = driver;
        this.loginSection = new NzzLoginSection(this.driver);
        this.headerSection = new NzzHeaderSection(this.driver);
    }

    public void getLoginPage() {
        driver.get("https://login.nzz.ch");
    }


}
