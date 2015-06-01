package grid;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class GridTests {


	@Test
	public void firefox1() throws IOException, InterruptedException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://gridfusion.net");

		Thread.sleep(2000);

		driver.quit();
	}
	

	@Test
	public void firefox2() throws IOException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://www.abraxas.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void firefox3() throws IOException, InterruptedException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://gridfusion.net");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void firefox4() throws IOException, InterruptedException {


		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://gridfusion.net");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void firefox5() throws IOException, InterruptedException {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();

		driver.get("http://www.abraxas.ch");
		Reporter.log("Page Title: " + driver.getTitle());

		driver.quit();
	}


}
