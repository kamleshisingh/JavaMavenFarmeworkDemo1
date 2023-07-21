package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLapsDemo {
	 public static void main(String[] args) {
	        // Lets WebDriverManager handle drivers
		 ChromeOptions co = new ChromeOptions();
		 co.addArguments("--remote-allow-origins=*");
	        WebDriverManager.chromedriver().setup();
	        // Starts session (opens browser)
	        RemoteWebDriver driver = new ChromeDriver(co);

	        // Opens browser with desired URL
	        driver.get("https://www.saucedemo.com");
	        // Inputs standard_user in username field.
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        // Inputs secret_sauce in password field
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");

	        // Clicks the Login button
	        driver.findElement(By.id("login-button")).click();

	        // maximizes browser window
	        driver.manage().window().maximize();

	        // Closes browser
	        driver.quit();
	    }

}
