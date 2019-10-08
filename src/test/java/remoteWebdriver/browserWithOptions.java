/*
 * Copyright (c) 2014 - 2019.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package remoteWebdriver;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class browserWithOptions {

	final String sboxUrl = "https://vm-106.element34.net/wd/hub";

	@Test
	public void chrome() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, "75"); //if left empty, the most recent browser version is used on SBOX
		options.setCapability("e34:l_testName", "Ein super duper Testname");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:userId", "Teamname (Teamemailadresse)");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
	}

	@Test
	public void firefox() throws MalformedURLException {

		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, "60"); //if left empty, the most recent browser version is used on SBOX
		options.setCapability("e34:l_testName", "Ein super duper Testname");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:userId", "Teamname (Teamemailadresse)");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
	}

	@Test
	public void withIEOptions() throws MalformedURLException {

		InternetExplorerOptions options = new InternetExplorerOptions();
		// IE browser version does not need to be selected
		options.setCapability("e34:l_testName", "Ein super duper Testname");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:userId", "Teamname (Teamemailadresse)");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
	}

	@Test
	public void withEdgeOptions() throws MalformedURLException {

		EdgeOptions options = new EdgeOptions();

		// Edge browser version does not need to be selected
		options.setCapability("e34:l_testName", "Ein super duper Testname");
		options.setCapability("e34:video", false); //boolean not String !!
		options.setCapability("e34:userId", "Teamname (Teamemailadresse)");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(sboxUrl), options);
	}

}
