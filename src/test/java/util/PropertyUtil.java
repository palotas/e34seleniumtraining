package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtil {
	
	public static Properties readProperties() throws FileNotFoundException, IOException {
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("config.properties"));
		
		System.out.println("GridURL: " + prop.getProperty("gridurl"));
		System.out.println("Browser: " + prop.getProperty("browser"));
		System.out.println("Version: " + prop.getProperty("version"));
		System.out.println("Platform: " + prop.getProperty("platform"));
		
		return prop;
	}

}
