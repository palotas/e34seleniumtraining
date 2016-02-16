package aargauPageObjectSamples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SteuernTest {
	

	@Test
	public void openPage() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ag.ch/de/system/suche/suche_startseite.jsp?lang=DE&searchfield=steuern&q=steuern&num=10&partialfields=");
		
		SteuernPage page = new SteuernPage(driver);
		page.selectThema();
		Thread.sleep(3000);
		driver.quit();
	}

	
	
}

