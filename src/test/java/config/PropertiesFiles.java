package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNg_Demo;

public class PropertiesFiles {
	static String pathPro =System.getProperty("user.dir");
	static Properties pro =new Properties();

	public static void main(String[] args) {
		System.out.println(getPropertyFileData("browser"));
		setPropertyFile("browser", "firefox");
		System.out.println(getPropertyFileData("browser"));
		setPropertyFile("browser", "chrome");
	}
	
	public static String getPropertyFileData(String key) {
		String value="";
		try {
			InputStream is = new FileInputStream(pathPro+"/src/test/java/config/config.properties");
			pro.load(is);
			value = pro.getProperty("browser");
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return value;
	}
	
	public static void setPropertyFile(String key, String value) {
		try {
			OutputStream os = new FileOutputStream(pathPro+"/src/test/java/config/config.properties");
			pro.setProperty(key, value);
			pro.store(os, null);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
