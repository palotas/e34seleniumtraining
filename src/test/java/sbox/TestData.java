package sbox;

import static sbox.Helpers.getAllChromes;

public class TestData {

    @org.testng.annotations.DataProvider(name = "chromeVersions", parallel = true)
    public Object[][] createData1() {
        return new Object[][] {
                {""},
                {"n-1"},
                {"n-2"},
                {"n-3"}
        };
    }

    @org.testng.annotations.DataProvider(name = "chromeVersions2", parallel = true)
    public Object[][] offsets() {
        return getAllChromes();
    }
}
