package ebayPageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ebayFlows.UserObject;

public class TheTest {
	
	@Test
	public void shouldEnterUsernamePassword() {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://signin.ebay.de/ws/eBayISAPI.dll?SignIn");
		UserObject user=new UserObject();
		user.setUserName("mysername");
		user.setPassword("test123");
		SigninPageWithModules page=new SigninPageWithModules(driver, user);
		page.moduleUsernamePassword.enterUsername();
		page.moduleUsernamePassword.enterPassword();
		
	}

}
