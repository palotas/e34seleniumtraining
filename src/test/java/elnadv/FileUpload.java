package elnadv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {


    @Test
    public void fileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://filebin.net");
        driver.findElement(By.id("fileField")).sendKeys("/home/e34/tmp/testfile.txt");
        Thread.sleep(2000);
        //driver.quit();
    }
}
