package grid;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class CapMismatch {


	@Test
	public void mismatch() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("safari");

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);

		driver.get("http://gridfusion.net");

		Thread.sleep(2000);

		driver.quit();
	}
	
}
