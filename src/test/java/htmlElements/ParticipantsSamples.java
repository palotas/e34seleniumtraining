package htmlElements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 23/09/15.
 */
public class ParticipantsSamples {


/*  CSHARP
    [Test]
    public void PageHasFiveRadioButtons()
    {
        IWebDriver driver = new FirefoxDriver();
        driver.Navigate().GoToUrl("http://gridfusion.net/testpage.html");

        var radioButtons = driver.FindElements(By.CssSelector("input[type='radio']"));
        Assert.AreEqual(5, radioButtons.Count);

        driver.Quit();
    }
  */


    @Test
    public void getAllCheckedElementsOnPage() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gridfusion.net/testpage.html");
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(":checked"));
        Assert.assertEquals(2, radioButtons.size());

        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void getAllElementsWithAnAttributeValue() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gridfusion.net/testpage.html");
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("[value]"));
        Assert.assertEquals(12, radioButtons.size());

        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void verify4LinksOnPage() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gridfusion.net/testpage.html");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("a[href]"));
        Assert.assertEquals(4, radioButtons.size());

        Thread.sleep(3000);
        driver.quit();
    }




    @Test
    public void pageHasFiveRadioButtonsCssSelector()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gridfusion.net/testpage.html");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        Assert.assertEquals(5, radioButtons.size());

        driver.quit();
    }


    @Test
    public void pageHasFiveRadioButtonsXpath()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gridfusion.net/testpage.html");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        Assert.assertEquals(5, radioButtons.size());

        driver.quit();
    }


    @Test
    public void fiveRadioButtons() {

        WebDriver driver = new FirefoxDriver();

        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        int countRadioButtons = 0;
        for (WebElement inputField : inputFields) {
            if ("radio".equals(inputField.getAttribute("type"))) {
                countRadioButtons++;
            }
        }
        Assert.assertEquals(countRadioButtons, 5);
    }


    @Test
    public void webdriverFirefoxTest() throws IOException, InterruptedException {

        // create DesiredCapabilities object and set browser to Firefox
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://gridfusion.net/testpage.html");

            List<WebElement> elements = driver.findElements(By.cssSelector("input[type=radio]"));
            int count = elements.size();
            System.out.println("count: " + count);

            Assert.assertEquals(count, 5);
            String[] baseElements = {"katze","hund","loewe","tiger","vogel"};
            for (int i = 0; i < elements.size(); i++) {
                Assert.assertEquals(elements.get(i).getAttribute("value"),baseElements[i]);
            }

        } finally {
            driver.quit();
        }
    }


    @Test
    public void findRadioButtons() throws InterruptedException {
        // create the driver and open Firefox
        WebDriver driver = new FirefoxDriver();
        try {
            // navigate to the URL
            driver.get("http://gridfusion.net/testpage.html");
            // RadioButtons
            List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

            System.out.println("radioButtons size = " + radioButtons.size());

            Assert.assertEquals(5, radioButtons.size());

            String[] tiere = {"katze", "hund", "loewe", "tiger", "vogel"};
            int c = 0;

            for (WebElement webElement : radioButtons) {
                System.out.println("Type = " + webElement.getAttribute("value"));

                Assert.assertEquals(tiere[c], webElement.getAttribute("value"));
                c++;
            }

        } finally {
            // close the Browser
            driver.quit();
        }
    }





//    @Test
//    public void findRadioButtonsAppended() {
//
//        List<WebElement> inputFields = findInputFields();
//
//        int countRadioButtons = 0;
//        StringBuffer sb = new StringBuffer();
//        for (WebElement inputField : inputFields) {
//            if ("radio".equals(inputField.getAttribute("type"))) {
//                countRadioButtons++;
//                System.out.println("found radioButton value: " + inputField.getAttribute("value"));
//                sb.append(inputField.getAttribute("value"));
//            }
//        }
//        System.out.println(sb.toString());
//        Assert.assertEquals(sb.toString(), "katzehundloewetigervogel");
//        Assert.assertEquals(countRadioButtons, 5);
//        System.out.println("found radioButtons count: " + countRadioButtons);
//    }


    @DataProvider(name = "dataprovider")
    public Object[][] createData() {
        return new Object[][] {{"http://gridfusion.net/testpage.html", //
                "input[type='radio']", new String[] {"katze", "hund", "loewe", "tiger", "vogel"}}};

    }

    @Test(dataProvider = "dataprovider")
    public void find(String url, String type, String values[]) throws InterruptedException, FileNotFoundException,
            IOException {

        // create the driver and open Firefox
        WebDriver driver = new FirefoxDriver();
        try {
            // navigate to the URL
            driver.get(url);
            List<WebElement> elements = driver.findElements(By.cssSelector(type));
            Assert.assertEquals(elements.size(), values.length);
            int i = 0;
            for (WebElement element : elements) {
                Assert.assertEquals(element.getAttribute("value"), values[i]);
                i++;
            }
        } finally {
            driver.quit();
        }
    }


    @DataProvider(name = "dataprovider")
    public Object[][] createData1() {
        return new Object[][] {{"http://gridfusion.net/testpage.html", //
                "input[type='radio']", new String[] {"katze", "hund", "loewe", "tiger", "vogel"}}};

    }

    @Test(dataProvider = "dataprovider")
    public void find1(String url, String type, String values[]) throws InterruptedException, FileNotFoundException,
            IOException {

        // create the driver and open Firefox
        WebDriver driver = new FirefoxDriver();
        try {
            // navigate to the URL
            driver.get("http://gridfusion.net/testpage.html");
            List<WebElement> elements = driver.findElements(By.cssSelector("input[type='radio']"));
            Assert.assertEquals(elements.size(), values.length);
            int i = 0;
            for (WebElement element : elements) {
                Assert.assertEquals(element.getAttribute("value"), values[i]);
                i++;
            }
        } finally {
            driver.quit();
        }
    }

    @DataProvider(name = "dataprovider")
    public Object[][] createData2() {
        return new Object[][] {{"http://gridfusion.net/testpage.html", "input", "type=radio", new Integer(5)}};
    }

    @Test(dataProvider = "dataprovider")
    public void find2(String url, String tagName, String attributes, Integer countResult) throws InterruptedException,
            FileNotFoundException, IOException {

        // create the driver and open Firefox
        WebDriver driver = new FirefoxDriver();
        try {
            // navigate to the URL
            driver.get(url);
            List<WebElement> elements = driver.findElements(By.tagName(tagName));
            int count = 0;
            HashMap<String, String> map = new HashMap<String, String>();
            StringTokenizer st = new StringTokenizer(attributes, "=&");
            while (st.hasMoreElements()) {
                map.put(st.nextToken(), st.hasMoreTokens() ? st.nextToken() : "");
            }
            boolean success;
            for (WebElement element : elements) {
                success = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!entry.getKey().equalsIgnoreCase(element.getAttribute(entry.getValue()))) {
                        success = false;
                    }
                }
                if (success) count++;
            }
            Assert.assertEquals(count, countResult.intValue());
        } finally {
            driver.quit();
        }
    }


}
