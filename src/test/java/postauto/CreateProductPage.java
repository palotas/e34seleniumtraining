package postauto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProductPage {


	
	@FindBy(id="edit-title-field-und-0-value")
	private WebElement titleField;
	
	@FindBy(id="edit-field-summary-und-0-value")
	private WebElement summaryField;	
	
	@FindBy(xpath="//*[@id='cke_contents_edit-body-und-0-value']/iframe")
	private WebElement editor;
	
	public CreateProductPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	

	
	public void enterTitle() {
		titleField.sendKeys("hier ist mein Titel");
	}
	
	public void enterSummary() {
		summaryField.sendKeys("und hier ist meine Summary");
	}
	
	public void enterEditor() {
		editor.sendKeys("und hier ist mein Versuch den Editor zu benutzen");
	}
		
	
	
	
}

