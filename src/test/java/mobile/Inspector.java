package mobile;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Inspector {
	
	@Test(enabled=true)
	public void androidAppTest() throws Exception {
	  SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
	  capa.setEmulator(false);
	  capa.setBrowserName("selendroid");
	  WebDriver driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"),capa);
	  
	  try {
		  driver.findElement(By.id("startUserRegistration")).click();

		  // Enter user name
		  WebElement username = driver.findElement(By.id("inputUsername"));
		  username.sendKeys("johndoe");
	  }
	  finally {
		  driver.quit();		  
	  }
	}

}
