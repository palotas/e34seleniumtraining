package sbox;

import com.google.common.base.Stopwatch;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleScrapperTest {
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @DataProvider(name = "urls", parallel = true)
    public Object[][] browsersProvider() {
        return new Object[][]{
                new Object[]{"https://www.seleniumconf.com/", chromeAndroid("Nexus 5X", "7.1.1")},
                new Object[]{"https://www.element34.com/", chromeAndroid("Nexus 5X", "8.0")},
                new Object[]{"https://seleniumbox.com/", chromeAndroid("Pixel", "7.1.1")},
                new Object[]{"https://appium.io/", chromeAndroid("Pixel", "8.0")},
        };
    }

    private DesiredCapabilities chromeAndroid(String deviceName, String platformVersion) {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        caps.setCapability(CapabilityType.PLATFORM, Platform.ANDROID); //changed from PLATFORM_NAME
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
        return caps;
    }

    @BeforeMethod(alwaysRun = true)
    public void setupWebDriver(Method testMethod, Object[] testArgs) throws MalformedURLException {
        DesiredCapabilities caps = (DesiredCapabilities) testArgs[1];
        String deviceName = (String) caps.getCapability(MobileCapabilityType.DEVICE_NAME);
        String testName = String.format("%s - %s", testArgs[0].toString(), deviceName);
        URL gridUrl = new URL("http://localhost:4444/wd/hub");
        caps.setCapability("e34:l_testName", testName);
        caps.setCapability("e34:video", true);
        Stopwatch watch = Stopwatch.createStarted();
        webDriver.set(new RemoteWebDriver(gridUrl, caps));
        System.out.println(testName + " -> started in: " + watch.elapsed(TimeUnit.SECONDS));
    }

    private WebDriver getWebDriver(){
        return webDriver.get();
    }

    @Test(dataProvider = "urls", threadPoolSize = 4)
    public void simpleScrapperTest(String url, DesiredCapabilities caps) throws InterruptedException {
        int pagesToNavigate = 5;
        int navigatedPages = 0;
        List<String> visitedUrls = new ArrayList<>();
        getWebDriver().get(url);
        String deviceName = (String) caps.getCapability(MobileCapabilityType.DEVICE_NAME);
        System.out.println(deviceName);
        SessionId id = ((RemoteWebDriver)getWebDriver()).getSessionId();
        System.out.println(String.format("Session ID: %s", id.toString()));
        while (navigatedPages < pagesToNavigate) {
            navigatedPages++;
            // Just to have a couple of seconds to see the page
            Thread.sleep(2000);
            List<WebElement> elements = getWebDriver().findElements(By.cssSelector("a[href]"));
            for (WebElement element : elements) {
                String href = element.getAttribute("href");
                if (!href.contains("#") &&
                        !href.equals(getWebDriver().getCurrentUrl()) &&
                        !visitedUrls.contains(href)) {
                    visitedUrls.add(href);
                    getWebDriver().get(href);
                    break;
                }
            }

        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        getWebDriver().quit();
    }
}