/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package seleniumbasics;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class Cookies {
	
	@Test
	public void cookies() throws IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		// Go to the URL
		driver.get("http://www.gridfusion.net");

		// Now set the cookie. This one is valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		// And now output all the available cookies for the current URL
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
		    System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
		}

		// You can delete cookies in 3 ways
		// By name
		driver.manage().deleteCookieNamed("CookieName");
		// By Cookie
		//driver.manage().deleteCookie(loadedCookie);
		// Or all of them
		driver.manage().deleteAllCookies();
		
		driver.quit();
	}
	


}
