package ebayTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ebayFlows.RegistrationFlow;
import ebayFlows.UserObject;

public class RegistrationTests {

	
	@Test
	public void regTest() {

		WebDriver driver=new FirefoxDriver();

		
		//set up user object
		UserObject user=new UserObject();
		user.setFirstName("testerFirst");
		user.setLastName("testerLast");
		user.setEmail("testerpalotasmytest@gmail.com");
		user.setPassword("mypassword$1122");
		user.setRepeatPassword("mypassword$1122");
		
		RegistrationFlow regFlow=new RegistrationFlow(driver);
		regFlow.fillInUserInformation(user, driver);
		
		
	}
	
	


}
