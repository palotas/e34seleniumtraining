package selendroid;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelendroidTest {
	
	@Test
	public void mySelendroidTest() throws Exception {

		SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.8.0");

		WebDriver driver = new SelendroidDriver(capa);
		WebElement inputField = driver.findElement(By.id("my_text_field"));
		Assert.assertEquals("true", inputField.getAttribute("enabled"));
		inputField.sendKeys("Selendroid");
		Assert.assertEquals("Selendroid", inputField.getText());
		driver.quit();
	}
	


}



