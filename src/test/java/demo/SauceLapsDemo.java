package demo;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLapsDemo {


    public static void main(String[] args)throws Exception {
    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 11");
    	browserOptions.setBrowserVersion("latest");
    	Map<String, Object> sauceOptions = new HashMap<>();
    	sauceOptions.put("username", "oauth-kannusingh108-4d0e0");
    	sauceOptions.put("accessKey", "884b609b-6aca-4528-96b2-191be47f06ee");
    	sauceOptions.put("build", "<your build id>");
    	sauceOptions.put("name", "<your test name>");
    	browserOptions.setCapability("sauce:options", sauceOptions);

    	
        // Create the WebDriver instance using the Sauce Labs URL and desired capabilities
    

    	URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    	RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
  

        // Perform any desired actions on the browser
        
        driver.get("https://www.google.com");
        System.out.println("Page Title: " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("automation step by step");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        

        // Close the browser and end the WebDriver session
        driver.quit();
        System.out.println("Test Completed!!!");
    }
}



