/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Locale extends BaseTest {
	@Test
	public void localeChrome() throws IOException {


		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions chromeOptions = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("intl.accept_languages", "de,de_DE");
		chromeOptions.setExperimentalOption("prefs", prefs);
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setCapability("video", false);
		chromeOptions.setCapability("e34:token", "72aa4d82" );

		caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca8.element34.net/wd/hub"), caps );

		driver.get("http://jenkins2.element34.net/");

		driver.quit();
	}


	@Test
	public void localeFirefox() throws MalformedURLException {


		DesiredCapabilities caps = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en,en_US");
		caps.setCapability("video", false);
		caps.setCapability("e34:token", "72aa4d82" );

		caps.setCapability(FirefoxDriver.PROFILE, profile);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca8.element34.net/wd/hub"), caps );

		driver.get("http://jenkins2.element34.net/");

		driver.quit();
	}

}
