package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static elnadv.Helpers.sleepTight;

/**
 * Created by e34 on 13/10/2017.
 */
public class DragDrop {

    @BeforeTest
    public void setup() {
        String OS = System.getProperty("os.name");

        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            case "Windows 10":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }


    @Test
    public void dragAndDrop() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions act = new Actions(driver);

        try {
            driver.get("http://jqueryui.com/droppable/");
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
            WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
            WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));
            act.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();

            sleepTight(3000);
            String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
            Assert.assertEquals(actualText, "Dropped!");

        }
        finally {
            driver.quit();
        }
    }
}
