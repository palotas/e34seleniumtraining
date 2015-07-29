package remoteWebdriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class RemoteWebdriverTests {

	@Test
	public void remoteWebdriverIETest() throws IOException, InterruptedException {

		//create DesiredCapabilities object and set browser to Firefox
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");				 
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://gridfusion.net");
		Thread.sleep(1000);
		driver.quit();		
	}
}
