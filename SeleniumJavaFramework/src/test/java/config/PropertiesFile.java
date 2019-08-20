package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.GoogleSearchTestByTestNG;

public class PropertiesFile {
	private static Properties props = new Properties();
	private static String currentPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		
		
		InputStream inputFile = null;
		try {
			inputFile = new FileInputStream(currentPath+"/src/test/java/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser = props.getProperty("browser");
		GoogleSearchTestByTestNG.browserName = browser;
		System.out.println("Property "+browser);
	}
	
	public static void setProperties() {
		try {
			OutputStream out = new FileOutputStream(currentPath+"/src/test/java/config/config.properties");
			props.setProperty("browser", "chrome");
			try {
				props.store(out, "successful");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
