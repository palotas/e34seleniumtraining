/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static elnadv.Helpers.sleepTight;

public class HighlightTest extends BaseTest {




	@Test
	public void highlight() throws IOException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://google.com");
		WebElement luckyButton = driver.findElement(By.name("btnI"));
		jse.executeScript("arguments[0].style.border='2px solid red'", luckyButton);
		sleepTight(5000);
		luckyButton.click();
		sleepTight(3000);
		driver.quit();
	}

}
