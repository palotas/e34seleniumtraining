/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.geolocation;

import com.fasterxml.jackson.databind.ser.Serializers;
import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.io.File;

public class Geolocation extends BaseTest {

    @Test
    public void setGelocation() {

        String fileName = "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\src\\test\\java\\elnadv\\geolocation\\geoLocation.json";
        WebDriver driver;
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.enabled", true);
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        //profile.setPreference("geo.provider.use_corelocation", true);
        profile.setPreference("geo.wifi.uri", new File(fileName).toURI().toString());
        driver = new FirefoxDriver(profile);
        driver.get("http://html5demos.com/geo");

    }
}
