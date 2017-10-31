/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Dimension extends BaseTest {

	@Test
	public void dimension() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(300, 500));
		driver.get("https://element34.com");

		Thread.sleep(5000);
		driver.quit();
	}

}
