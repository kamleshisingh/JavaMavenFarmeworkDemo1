package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsTest {
	WebDriver driver;
	ChromeOptions co;
	@Test
	public void test1() {
		System.out.println("launching the browser >>");
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		
	}
	@Test
	public void test2() {
		System.out.println("exicuting the tests...>>>>>>");
		driver.get("https://google.co.in");
		driver.findElement(By.name("q")).sendKeys(" hello google");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	@Test
	public void test3() {
		System.out.println("terminating the test now!!!!!!!!!");
		driver.quit();
	}

}
