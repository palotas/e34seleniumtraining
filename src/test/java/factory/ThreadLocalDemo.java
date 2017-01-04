package factory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by e34 on 01.01.17.
 */

public class ThreadLocalDemo {

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

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }

    @Test
    public void testMethod1() {
        invokeBrowser("http://www.ndtv.com");
    }

    @Test
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");

    }

    @Test
    public void test() {
    }

    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);

    }
}
