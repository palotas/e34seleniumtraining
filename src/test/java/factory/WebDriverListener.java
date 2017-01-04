package factory;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.net.MalformedURLException;


/**
 * Created by e34 on 01.01.17.
 */


public class WebDriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        setDriverPaths();

        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");

            //if executing not via testng.xml then set default to chrome
            if (browserName == null ) {
                browserName = "chrome";
            }
            WebDriver driver = null;
            try {
                driver = LocalDriverFactory.createInstance(browserName);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            LocalDriverManager.setWebDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private void setDriverPaths() {
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

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }
}
