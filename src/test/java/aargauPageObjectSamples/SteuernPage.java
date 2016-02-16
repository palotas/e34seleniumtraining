package aargauPageObjectSamples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SteuernPage {
	
	
	@FindBy(id="thema")
	private WebElement dummyThema;
	
	public SteuernPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void selectThema() {
		Select thema = new 	Select(dummyThema);
		thema.selectByIndex(2);
	}
	
}

