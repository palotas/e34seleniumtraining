package ebayTests;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ebayPageObjects.MyEbayPage;
import ebayPageObjects.SigninPage;
import ebayPageObjects.ViewItemPage;

public class WatchListPageObjectTests {
	
    @Test
    public void addItemToWatchListWithPageObjects() throws InterruptedException {

            WebDriver driver = new FirefoxDriver();
            SigninPage signinpage = new SigninPage(driver);
            
            MyEbayPage myEbayPage = signinpage.signIn(driver);
            myEbayPage.enterItemNumber();
            ViewItemPage viewItemPage = myEbayPage.clickSearchBox(driver);
            viewItemPage.clickWatchListButton();
            Assert.assertTrue(viewItemPage.getMessagePanelText().contains("Hinzugefügt zu Ihrer Beobachtungsliste"));

            
            Thread.sleep(5000);
            driver.quit();
            
    }

}
