package postauto;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SigninTest {

	@Test
	public void signinTest() throws InterruptedException, MalformedURLException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://cando:melius@postauto-test-web.cando-image.com/user");
		
		
		SigninPage signinPage=new SigninPage(driver);
		signinPage.enterUsername();
		signinPage.enterPassword();
		signinPage.clickLoginButton();
	}
}