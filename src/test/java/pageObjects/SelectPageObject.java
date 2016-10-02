package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by gridfusion on 07/05/16.
 */
public class SelectPageObject {


    @FindBy(id="dropdown")
    private WebElement wannabeSelect;


    public SelectPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void selectDropdown() throws InterruptedException {

        Select realSelect = new Select(wannabeSelect);
        realSelect.selectByIndex(2);
    }
}
