/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.geolocation;

import elnadv.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Geolocation extends BaseTest {

    @Test
    public void setGelocation() {

        String fileName = "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\src\\test\\java\\elnadv\\geolocation\\geoLocation.json";


        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.enabled", true);
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        profile.setPreference("geo.provider.use_corelocation", true);
        profile.setPreference("geo.wifi.uri", new File(fileName).toURI().toString());
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(profile);
        WebDriver driver = new FirefoxDriver(opt);


        driver.get("http://html5demos.com/geo");


    }


    @Test
    public void geoLocationChrome() {
        Map prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.geolocation", 1); // 1:allow 2:block

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        ChromeDriver driver = new ChromeDriver(options);

        ((LocationContext)driver).setLocation(new Location(37.774929, -122.419416, 0));
        driver.get("https://html5demos.com/geo/");

    }
}

