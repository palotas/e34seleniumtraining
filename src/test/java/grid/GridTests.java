package grid;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GridTests {

	@DataProvider(name = "capabilitiesProvider", parallel=true)
	public Object[][] getCapabilities() {
		return new Object[][] {
				{DesiredCapabilities.firefox()},
				{DesiredCapabilities.chrome()}
		};
	}


	@Test(dataProvider = "capabilitiesProvider")
	public void test1(DesiredCapabilities capability) throws IOException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.axa.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test2(DesiredCapabilities capability) throws IOException, InterruptedException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.google.com");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test3(DesiredCapabilities capability) throws IOException, InterruptedException {


		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.20minuten.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test(dataProvider = "capabilitiesProvider")
	public void test4(DesiredCapabilities capability) throws IOException, InterruptedException {

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.get("http://www.nzz.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}


}
