package seleniumbasics;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class Cookies {
	
	@Test
	public void cookies() throws FileNotFoundException, IOException {
		
		WebDriver driver = util.DriverFactory.createRemoteFirefoxDriver();

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
