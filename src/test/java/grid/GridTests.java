package grid;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class GridTests {



	@Test
	public void test1() throws IOException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://www.axa.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void test2() throws IOException, InterruptedException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://www.google.com");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void test3() throws IOException, InterruptedException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://www.20minuten.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void test4() throws IOException, InterruptedException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteFirefoxDriver();

		driver.get("http://www.nzz.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}


}
