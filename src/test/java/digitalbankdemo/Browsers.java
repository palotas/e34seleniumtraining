package digitalbankdemo;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

public class Browsers {

    @DataProvider(name = "chrome-latest", parallel = true)
    public Object[][] caps1() {
        return new Object[][] {
                {DesiredCapabilities.chrome(), ""},
        };
    }


    @DataProvider(name = "chrome-ff", parallel = true)
    public Object[][] caps2() {
        return new Object[][] {
                {DesiredCapabilities.chrome(), "85"},
                {DesiredCapabilities.chrome(), "84"},
                {DesiredCapabilities.firefox(), "76"},
                {DesiredCapabilities.firefox(), "75"},

        };
    }

    @DataProvider(name = "all", parallel = true)
    public Object[][] caps3() {
        return new Object[][] {
                {DesiredCapabilities.chrome(), "85"},
                {DesiredCapabilities.chrome(), "84"},
                {DesiredCapabilities.firefox(), "76"},
                {DesiredCapabilities.firefox(), "75"},
                {DesiredCapabilities.edge(), ""},
                {DesiredCapabilities.internetExplorer(), "11"},
        };
    }
}
