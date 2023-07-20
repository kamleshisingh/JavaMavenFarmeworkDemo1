package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	@Test
	public void test()throws Exception {
		System.out.println(">>>>>>test Stareted<<<<<<");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*","--headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://google.co.in");
		System.out.println("titel is : "+driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("automation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		driver.quit();
		System.out.println(">>>>completed<<<<<<<");
		
		
	}

}
