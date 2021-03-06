/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Scroll extends BaseTest {

	@Test
	public void scroll() throws InterruptedException, IOException {

		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://www.element34.net");
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
