package elnadv;

import elnadv.pageObjects.NzzLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by e34 on 13/10/2017.
 */
public class ExpectedException {

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


    @Test//(expectedExceptions = NoSuchElementException.class)
    public void checkThatElementNotOnPage() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {

            driver.get("https://google.com");
            driver.findElement(By.id("abc")); //this element should not be on the page
        }
        finally {
            driver.quit();
        }

    }

}
