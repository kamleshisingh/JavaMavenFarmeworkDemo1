package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	WebDriver driver;
	@Test
	public void seleniumWait() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		/*.......implicit wait........*/
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		
		driver.get("https://google.co.in");
		
		WebElement searchInputBox =driver.findElement(By.name("q"));
		WebElement searchBtn= driver.findElement(By.xpath("//input[@name='btnK']"));
		
		searchInputBox.sendKeys("automation step by step");
		searchBtn.sendKeys(Keys.RETURN);
		
		/*............explicit wait......... */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("1244522"))));
		
		
		
		driver.close();
		driver.quit();
		
	}

}
