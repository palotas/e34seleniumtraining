package sbox;

import org.testng.SkipException;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public final static String[] CHROME_VERSIONS = {"58", "59", "60","61"};
    public final static String[] CHROME_SKIP_VERSIONS = {"58"};

    public static Object[][] getAllChromes() {
        Object[][] objects = new Object[(CHROME_VERSIONS.length)][];
        for (int i = 0; i < CHROME_VERSIONS.length; i++) {
            objects[i] = new Object[]{CHROME_VERSIONS[i]};
        }
        return objects;
    }

    public static void checkChromeVersionToSkip(String version) {
        List<String> versionList = new ArrayList<>();
        for (int i = 0; i < CHROME_SKIP_VERSIONS.length; i++) {
            versionList.add(CHROME_SKIP_VERSIONS[i]);
        }

        if (versionList.contains(version)) {
            throw new SkipException("unsupported Chrome Version for PKI ");
        }
    }
}
