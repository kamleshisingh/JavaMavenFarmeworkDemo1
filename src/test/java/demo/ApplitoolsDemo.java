package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplitoolsDemo {
	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(co);
		
		Eyes eyes = new Eyes();
		eyes.setApiKey("22Egd6IlM5107xoXGleNKxKqg105BNagdc0gcQ28WmnjuWA110");
		
		try {
			eyes.open(driver, "hello World!", "my first selenium java test ", new RectangleSize(800,600));
			
			driver.get("https://applitools.com/helloworld");
			eyes.checkWindow("Hello!");
			driver.findElement(By.linkText("?diff1")).click();
			eyes.checkWindow("Check!");
			eyes.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
			eyes.abortIfNotClosed();
		}
		System.out.println(" test passed");
		
	}

}
