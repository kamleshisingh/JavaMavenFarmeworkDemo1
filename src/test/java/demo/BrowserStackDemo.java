		package demo;

import java.net.MalformedURLException;
import java.util.HashMap;

import javax.swing.JApplet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {
	public static final String USERNAME = "kamleshsingh_X08Ypu";
    public static final String AUTOMATE_KEY = "SyUg48NnwxpqepjGnHX3";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
                                    + "@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String []args) throws Exception {
		/* this capabilities for windows devices*/
		/*
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "11");
		browserstackOptions.put("browserVersion", "latest");
		browserstackOptions.put("projectName", "Test");
		browserstackOptions.put("buildName", "build1");
		browserstackOptions.put("sessionName", "Test1");
		browserstackOptions.put("local", "false");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("networkLogs", "true");
		browserstackOptions.put("seleniumVersion", "4.8.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		*/	
		/*this is foe apple product phone*/
		/*
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("osVersion", "16");
		browserstackOptions.put("deviceName", "iPhone 14");
		browserstackOptions.put("projectName", "Test");
		browserstackOptions.put("buildName", "build2");
		browserstackOptions.put("sessionName", "Test2");
		browserstackOptions.put("local", "false");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("networkLogs", "true");
		capabilities.setCapability("bstack:options", browserstackOptions);
		*/
		/*this is for android phone */
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "samsung");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("osVersion", "10.0");
		browserstackOptions.put("deviceName", "Samsung Galaxy S20");
		browserstackOptions.put("projectName", "Test");
		browserstackOptions.put("buildName", "build3");
		browserstackOptions.put("sessionName", "Test3");
		browserstackOptions.put("local", "true");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("networkLogs", "true");
		capabilities.setCapability("bstack:options", browserstackOptions);


		
		RemoteWebDriver driver = new RemoteWebDriver( new java.net.URL(URL), capabilities);

        try {
            // Navigate to a website
            driver.get("https://google.co.in");
            driver.findElement(By.name("q")).sendKeys("browser Stack demo");
//            driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Perform some actions (e.g., interact with elements)
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the WebDriver and release resources
            driver.quit();

		}
     }
}

	
	
	